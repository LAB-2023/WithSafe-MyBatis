package com.withsafe.domain.department.application;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.withsafe.domain.department.dao.DepartmentMapper;
import com.withsafe.domain.department.domain.Department;
import com.withsafe.domain.department.domain.DepartmentJpa;
import com.withsafe.domain.department.dto.DepartmentDTO;
import com.withsafe.domain.department.exception.DepartmentAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 필요 기능
 * 1. 부서 생성
 * 2. 부서 내 유저 조회
 * 3. 유저 부서 변경
 * 4. 유저 삭제..?
 */
@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentMapper departmentMapper;

    //부서 생성
    @Transactional
    public Long saveDepartment(DepartmentDTO.saveDepartment request) {
        Department newDepartment = request.toEntity();

        // 같은 이름의 부서가 존재하는지 확인
        if (departmentMapper.existsByName(newDepartment.getName()) > 0) {
            throw new DepartmentAlreadyExistsException("같은 이름을 가진 부서가 이미 존재합니다.");
        }

        departmentMapper.save(newDepartment);
        return newDepartment.getId();
    }


    //유저 조회

    //유저 부서 변경

    //유저 삭제

    //모든 부서 이름 받기
    public PageInfo<String> findAllDepartmentName(int page, int size, String departmentName){
        PageHelper.startPage(page, size);
        List<String> excepts = Arrays.asList("MASTER", "SBSystems");
        List<String> result = departmentMapper.findAllExceptDepartments(excepts, departmentName)
                .stream()
                .map(Department::getName)
                .collect(Collectors.toList());
        return new PageInfo<>(result);
    }
}


