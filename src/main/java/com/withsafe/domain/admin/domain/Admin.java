package com.withsafe.domain.admin.domain;


import com.withsafe.domain.admin.dto.AdminDto;
import com.withsafe.domain.department.domain.Department;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@RequiredArgsConstructor
public class Admin {

    @Id
    @GeneratedValue
    @Column(name = "admin_id")
    private Long id;

    private String name;
    private String loginId;
    private String loginPassword;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="department_id")
    private Department department;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Builder
    public Admin(Long id, String name, String loginId, String loginPassword, Authority authority, Department department) {
        this.id = id;
        this.loginId = loginId;
        this.loginPassword = loginPassword;
        this.name = name;
        this.authority = authority;
        this.department = department;
    }

    public static Admin toEntity(AdminDto.AdminSaveRequestDto adminSaveRequestDto, Department department, String encodedPassword){
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
