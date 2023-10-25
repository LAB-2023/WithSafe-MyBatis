package com.withsafe.domain.admin.application;

import com.withsafe.domain.admin.dao.AdminRepository;
import com.withsafe.domain.admin.domain.Admin;
import com.withsafe.domain.admin.domain.AdminType;
import com.withsafe.domain.admin.dto.AdminDto;
import com.withsafe.domain.admin.exception.DuplicateEmailException;
import com.withsafe.domain.department.dao.DepartmentRepository;
import com.withsafe.domain.department.domain.Department;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.GeneralSecurityException;
import java.util.Optional;

import static com.withsafe.domain.admin.dto.AdminDto.*;
import static com.withsafe.domain.admin.dto.AdminDto.LoginResponseDto.*;

/**
 * 필요 기능
 * 1. 회원가입 -> 일단 만듬
 * 2. 로그인
 * 3. 로그아웃
 * 4. 비밀번호 찾기(변경) -> 일단 만듬
 */

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AdminService {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    private final DepartmentRepository departmentRepository;

    //회원 가입
    @Transactional
    public Long signup(AdminSaveRequestDto adminSaveRequestDto){
        if(loginIdDuplicateCheck(adminSaveRequestDto.getLoginId())){
            throw new DuplicateEmailException();
        }

        Department department = departmentRepository.findByName(adminSaveRequestDto.getDepartmentName());
        //입력받은 type이 master면 부서가 없다는 가정 하에 체크 -> 부서에 본사나 SBS가 들어오면 수정해야함!!
//        if(!adminSaveRequestDto.getType().equals(AdminType.MASTER)){
//            department = departmentRepository.findByName(adminSaveRequestDto.getDepartmentName());
//        }
        if(department == null){
            throw new IllegalStateException("부서가 없습니다.");
        }
        adminSaveRequestDto.passwordEncryption(passwordEncoder);
        Admin admin = adminSaveRequestDto.toEntity(department);
        adminRepository.save(admin);

        return admin.getId();
    }

    /***
     * 로그인
     * @param loginRequestDto - 로그인 정보 dto
     * @return - 회원 정보
     */
    public LoginResponseDto login(LoginRequestDto loginRequestDto){
        Admin admin = adminRepository.findByLoginId(loginRequestDto.getLoginId());
        String encodedPassword = (admin == null) ? "" : admin.getLoginPwd();
        if(admin == null || !passwordEncoder.matches(loginRequestDto.getPassword(), encodedPassword)){
            return null;
        }
        //부서이름 받아오기
        Department department = admin.getDepartment();
        String departmentName = department.getName();
        return toLoginResponseDto(admin.getId(), admin.getName(), admin.getLoginId(), admin.getType(), departmentName);
    }

    private boolean loginIdDuplicateCheck(String loginId){
        return adminRepository.existsByLoginId(loginId);
    }
}
