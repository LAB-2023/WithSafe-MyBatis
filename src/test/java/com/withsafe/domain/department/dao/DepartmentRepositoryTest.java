package com.withsafe.domain.department.dao;

import com.withsafe.domain.department.application.DepartmentService;
import com.withsafe.domain.department.domain.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class DepartmentRepositoryTest {

    @Autowired
    DepartmentService departmentService;

//    @Test
//    public void 부서생성() {
//        Department department = new Department("teamA");
//        departmentService.saveDepartment(department.toSaveDepartmentDTO());
//    }

}