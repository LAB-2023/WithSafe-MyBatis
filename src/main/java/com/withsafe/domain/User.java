package com.withsafe.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class User {
    @Id @GeneratedValue
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
    private String sex;
}
