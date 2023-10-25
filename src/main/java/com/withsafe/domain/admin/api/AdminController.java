package com.withsafe.domain.admin.api;

import com.withsafe.domain.admin.application.AdminService;
import com.withsafe.domain.department.application.DepartmentService;
import com.withsafe.domain.department.dto.DepartmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.withsafe.domain.admin.constant.SessionConstants.*;
import static com.withsafe.domain.admin.dto.AdminDto.*;

@Controller
@RestController
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;
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
        //
    }
    //유저 생성
    @PostMapping("/signup-api")
    public AdminSaveRequestDto signup(@RequestBody AdminSaveRequestDto adminSaveRequestDto){
        adminService.signup(adminSaveRequestDto);
        return adminSaveRequestDto;
    }

    //로그인
    @GetMapping("/login-api")
    @ResponseBody
    public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto, HttpServletRequest request){

        LoginResponseDto loginInfo = adminService.login(loginRequestDto);
        if(loginInfo != null){
            request.getSession().invalidate();
            HttpSession session = request.getSession();
            session.setAttribute(LOGIN_INFO, loginInfo);
            session.setMaxInactiveInterval(1800);
        }
        return loginInfo;
    }

    //로그아웃
    @PostMapping("/logout-api")
    public void logout(HttpSession session){
        session.invalidate();
    }
}
