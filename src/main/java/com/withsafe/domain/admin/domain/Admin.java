package com.withsafe.domain.admin.domain;


import com.withsafe.domain.department.domain.Department;
import com.withsafe.domain.department.domain.DepartmentJpa;
import lombok.*;

import javax.persistence.*;

import static com.withsafe.domain.admin.dto.AdminDto.*;

@Getter
@NoArgsConstructor
public class Admin {

    private Long id;
    private String name;
    private String loginId;
    private String loginPassword;
    private Authority authority;
    private Department department;

    @Builder
    public Admin(Long id, String name, String loginId, String loginPassword, Authority authority, Department department) {
        this.id = id;
        this.name = name;
        this.loginId = loginId;
        this.loginPassword = loginPassword;
        this.authority = authority;
        this.department = department;
    }

    public static Admin toEntity(AdminSaveRequestDto adminSaveRequestDto, Department department, String encodedPassword){
        return Admin
                .builder()
                .name(adminSaveRequestDto.getName())
                .loginId(adminSaveRequestDto.getLoginId())
                .loginPassword(encodedPassword)
                .authority(adminSaveRequestDto.getAuthority())
                .department(department)
                .build();
    }
}
