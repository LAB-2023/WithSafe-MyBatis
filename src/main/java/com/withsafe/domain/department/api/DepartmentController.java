package com.withsafe.domain.department.api;

import com.withsafe.domain.department.application.DepartmentService;
import com.withsafe.domain.department.dto.DepartmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deviceSetting")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping
    public DepartmentDTO.saveDepartment saveDepartment(@RequestBody DepartmentDTO.saveDepartment request) {
        departmentService.saveDepartment(request);
        return request;
    }
}
