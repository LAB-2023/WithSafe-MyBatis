package com.withsafe.domain.admin.dto;

import com.withsafe.domain.admin.domain.Admin;
import com.withsafe.domain.admin.domain.Authority;
import com.withsafe.domain.department.domain.Department;
import com.withsafe.domain.department.domain.DepartmentJpa;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.lang.reflect.Field;

public class AdminDto {
    @Getter
    @NoArgsConstructor
    public static class AdminSaveRequestDto{
        private String name;
        private String loginId;
        private String loginPassword;
        @Enumerated(value = EnumType.STRING)
        private Authority authority;
        private String departmentName;

        @Builder
        public AdminSaveRequestDto(String name, String loginId, String loginPassword, Authority authority, String departmentName) {
            this.name = name;
            this.loginId = loginId;
            this.loginPassword = loginPassword;
            this.authority = authority;
            this.departmentName = departmentName;
        }

        public Admin toEntity(Department department){
            return Admin.builder()
                    .name(this.name)
                    .loginId(this.loginId)
                    .loginPassword(this.loginPassword)
                    .authority(this.authority)
                    .department(department)
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor
    public static class LoginRequestDto {
        private String loginId;
        private String loginPassword;

        @Builder
        public LoginRequestDto(String loginId, String loginPassword) {
            this.loginId = loginId;
            this.loginPassword = loginPassword;
        }

        public UsernamePasswordAuthenticationToken toAuthentication(){
            return new UsernamePasswordAuthenticationToken(loginId, loginPassword);
        }
    }

    @Getter
    @NoArgsConstructor
    public static class LoginResponseDto {
        private Long id;
        private String name;
        private String loginId;
        private Authority authority;
        private String departmentName;

        @Builder
        public LoginResponseDto(Long id, String name, String loginId, Authority authority, String departmentName) {
            this.id = id;
            this.name = name;
            this.loginId = loginId;
            this.authority = authority;
            this.departmentName = departmentName;
        }


        public static LoginResponseDto of(Admin admin, String departmentName){
            return LoginResponseDto
                    .builder()
                    .id(admin.getId())
                    .name(admin.getName())
                    .loginId(admin.getLoginId())
                    .authority(admin.getAuthority())
                    .departmentName(departmentName)
                    .build();
        }

        //Setter없이 데이터 수정하는 방법
        public void modifyDepartmentName(String departmentName) throws NoSuchFieldException, IllegalAccessException {
            Field changeField = this.getClass().getDeclaredField("departmentName");
            changeField.setAccessible(true);
            changeField.set(this, departmentName);
        }
    }
}
