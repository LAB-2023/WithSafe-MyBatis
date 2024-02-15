package com.withsafe.domain.department.api;

import com.github.pagehelper.PageInfo;
import com.withsafe.domain.department.application.DepartmentService;
import com.withsafe.domain.department.dto.DepartmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.withsafe.domain.department.dto.DepartmentDTO.*;

@CrossOrigin("http://localhost:3000")
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
    public ResponseEntity<PageInfo> findDepartment(@RequestParam("page") int page,
                                                   @RequestParam("size") int size,
                                                   @RequestParam(value = "departmentName", required = false) String department){
        return ResponseEntity.ok(departmentService.findAllDepartmentName(page, size, department));
    }
}
