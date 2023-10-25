package com.withsafe.domain.admin.dto;

import com.withsafe.domain.admin.domain.Admin;
import com.withsafe.domain.admin.domain.AdminType;
import com.withsafe.domain.department.domain.Department;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class AdminDto {

    @Getter
    @NoArgsConstructor
    public static class AdminSaveRequestDto{
        private String name;
        private String loginId;
        private String password;
        @Enumerated(value = EnumType.STRING)
        private AdminType type;
        private String departmentName;

        public void passwordEncryption(PasswordEncoder passwordEncoder) {
            this.password = passwordEncoder.encode(password);
        }

        @Builder
        public AdminSaveRequestDto(String name, String loginId, String password, AdminType type, String departmentName) {
            this.name = name;
            this.loginId = loginId;
            this.password = password;
            this.type = type;
            this.departmentName = departmentName;
        }

        public Admin toEntity(Department department){
            return Admin.builder()
                    .name(this.name)
                    .loginId(this.loginId)
                    .loginPwd(this.password)
                    .type(this.type)
                    .department(department)
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor
    public static class LoginRequestDto {
        private String loginId;
        private String password;

        @Builder
        public LoginRequestDto(String loginId, String password) {
            this.loginId = loginId;
            this.password = password;
        }

    }

    @Getter
    @NoArgsConstructor
    public static class LoginResponseDto {
        private Long id;
        private String name;
        private String loginId;
        private AdminType type;
        private String departmentName;

        @Builder
        public LoginResponseDto(Long id, String name, String loginId, AdminType type, String departmentName) {
            this.id = id;
            this.name = name;
            this.loginId = loginId;
            this.type = type;
            this.departmentName = departmentName;
        }

        public static LoginResponseDto toLoginResponseDto(Long id, String name, String loginId, AdminType type, String departmentName){
            return LoginResponseDto
                    .builder()
                    .id(id)
                    .name(name)
                    .loginId(loginId)
                    .type(type)
                    .departmentName(departmentName)
                    .build();
        }
    }
}
