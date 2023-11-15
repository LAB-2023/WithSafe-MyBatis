package com.withsafe.domain.department.api;

import com.withsafe.domain.department.application.DepartmentService;
import com.withsafe.domain.department.dto.DepartmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.withsafe.domain.department.dto.DepartmentDTO.*;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping
    public saveDepartment saveDepartment(@RequestBody saveDepartment request) {
        departmentService.saveDepartment(request);
        return request;
    }

    @GetMapping
    public List<String> allDepartmentName(){
        return departmentService.findAllDepartmentName();
    }
}
