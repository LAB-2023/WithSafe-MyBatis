package com.withsafe.domain.admin.api;

import com.withsafe.domain.admin.application.AdminService;
import com.withsafe.domain.department.application.DepartmentService;
import com.withsafe.domain.department.dto.DepartmentDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.withsafe.domain.admin.constant.SessionConstants.*;
import static com.withsafe.domain.admin.dto.AdminDto.*;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class AdminController {

    private final DepartmentService departmentService;

    @PostMapping("/department-test")
    public void test(){
        //테스트용 DEPARTMENT INPUT
        DepartmentDTO.saveDepartment saveDepartment = new DepartmentDTO.saveDepartment("TEST_DEPARTMENT");
        departmentService.saveDepartment(saveDepartment);
        DepartmentDTO.saveDepartment saveDepartment2 = new DepartmentDTO.saveDepartment("SBSYSTEMS");
        departmentService.saveDepartment(saveDepartment2);
        DepartmentDTO.saveDepartment saveDepartment3 = new DepartmentDTO.saveDepartment("MAINCOMPANY");
        departmentService.saveDepartment(saveDepartment3);
        DepartmentDTO.saveDepartment saveDepartment4 = new DepartmentDTO.saveDepartment("TESTCOMPANY");
        departmentService.saveDepartment(saveDepartment4);
        //
    }
}
