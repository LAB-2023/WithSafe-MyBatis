package com.withsafe.domain.admin.domain;

import com.withsafe.domain.department.domain.Department;
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

    private String loginId;
    private String loginPwd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="department_id")
    private Department department;

    @Enumerated(EnumType.STRING)
    private AdminType type;
}
