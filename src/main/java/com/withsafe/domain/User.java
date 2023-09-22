package com.withsafe.domain;


import com.withsafe.domain.device.Watch;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
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

    @OneToOne(mappedBy = "watch", fetch = FetchType.LAZY)
    private Watch watch;

    //FK
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    // == 연관관계 편의 메서드 == //
    public void setDepartment(Department department) {
        this.department = department;
        department.getUserList().add(this);
    }
}
