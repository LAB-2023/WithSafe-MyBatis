package com.withsafe.domain.department.application;

import com.withsafe.domain.department.dao.DepartmentRepository;
import com.withsafe.domain.department.domain.Department;
import com.withsafe.domain.department.dto.DepartmentDTO;
import com.withsafe.domain.department.exception.DepartmentAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    private final DepartmentRepository departmentRepository;

    //부서 생성
    @Transactional
    public Long saveDepartment(DepartmentDTO.saveDepartment request) {
        Department newDepartment = request.toEntity();

        // 같은 이름의 부서가 존재하는지 확인
        if (departmentRepository.existsByName(newDepartment.getName())) {
            throw new DepartmentAlreadyExistsException("같은 이름을 가진 부서가 이미 존재합니다.");
        }

        departmentRepository.save(newDepartment);
        return newDepartment.getId();
    }


    //유저 조회

    //유저 부서 변경

    //유저 삭제
}


