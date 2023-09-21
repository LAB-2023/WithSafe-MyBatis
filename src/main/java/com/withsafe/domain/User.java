package com.withsafe.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class User {
    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String name;
    private int age;
    private String phone_num;
    private String emergency_contact;
    private String emergency_relation;
    private int heartRate_threshold;
    private int oxygen_threshold;
    private int walk_threshold;
    private double height;
    private double weight;

    @Enumerated(value = EnumType.STRING)
    private Sex sex;

    //FK
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;
}
