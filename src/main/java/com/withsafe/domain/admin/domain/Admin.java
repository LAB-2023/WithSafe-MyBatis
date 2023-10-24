package com.withsafe.domain.admin.domain;

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

    @Enumerated(EnumType.STRING)
    private AdminType type;
}
