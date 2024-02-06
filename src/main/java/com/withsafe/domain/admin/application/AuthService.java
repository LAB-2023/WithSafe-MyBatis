package com.withsafe.domain.admin.application;

import com.withsafe.domain.admin.dao.AdminMapper;
import com.withsafe.domain.admin.domain.Admin;
import com.withsafe.domain.admin.domain.Authority;
import com.withsafe.domain.admin.dto.TokenDto;
import com.withsafe.domain.department.dao.DepartmentMapper;
import com.withsafe.domain.department.domain.Department;
import com.withsafe.global.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static com.withsafe.domain.admin.dto.AdminDto.*;


@Service
@RequiredArgsConstructor
@Transactional
public class AuthService {
    private final AuthenticationManagerBuilder managerBuilder;
    private final PasswordEncoder passwordEncoder;
    private final DepartmentMapper departmentMapper;
    private final TokenProvider tokenProvider;
    private final AdminMapper adminMapper;

    //회원가입
    public int signup(AdminSaveRequestDto requestDto){
        if(adminMapper.existsByLoginId(requestDto.getLoginId()) > 0){
            throw new RuntimeException("이미 가입되어 있는 유저입니다.");
        }
        String encodePassword = passwordEncoder.encode(requestDto.getLoginPassword());
        Department department = departmentMapper
                .findByName(requestDto.getDepartmentName()).orElseThrow(() -> new RuntimeException("부서가 존재하지 않습니다."));
        Admin admin = Admin.toEntity(requestDto, department, encodePassword);
        return adminMapper.save(admin);
    }

    //로그인
    public TokenDto login(LoginRequestDto requestDto){
        UsernamePasswordAuthenticationToken authenticationToken = requestDto.toAuthentication();
        try{
            Authentication authentication = managerBuilder.getObject().authenticate(authenticationToken);
            Admin admin = adminMapper.findById(Long.valueOf(authentication.getName()))
                    .orElseThrow(() -> new RuntimeException("존재하지 않는 사용자 입니다."));
            String departmentName;
            if(admin.getAuthority().equals(Authority.ROLE_MASTER)){
                List<String> excepts = Arrays.asList("MASTER", "SBSystems");
                List<Department> departments = departmentMapper.findAllExceptDepartments(excepts);
                departmentName = departments.get(0).getName();
            }else{
                Department department = departmentMapper.findById(admin.getDepartment().getId())
                        .orElseThrow(() -> new IllegalArgumentException("해당 부서가 없습니다."));
                departmentName = department.getName();
            }
            return tokenProvider.generateTokenDto(authentication, admin.getName(), departmentName, admin.getAuthority());
        }catch (RuntimeException e){
            e.printStackTrace();
            throw new RuntimeException("아이디나 비밀번호를 확인해주세요.");
        }
    }
}
