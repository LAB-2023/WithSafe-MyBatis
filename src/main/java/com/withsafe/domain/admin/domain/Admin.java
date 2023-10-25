package com.withsafe.domain.admin.domain;

import com.withsafe.domain.admin.dto.AdminDto;
import com.withsafe.domain.department.domain.Department;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

import static com.withsafe.domain.admin.dto.AdminDto.*;

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
    private String loginPwd;

    @Enumerated(EnumType.STRING)
    private AdminType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @Builder
    public Admin(Long id, String name, String loginId, String loginPwd, AdminType type, Department department) {
        this.id = id;
        this.loginId = loginId;
        this.loginPwd = loginPwd;
        this.name = name;
        this.type = type;
        this.department = department;
    }
}
