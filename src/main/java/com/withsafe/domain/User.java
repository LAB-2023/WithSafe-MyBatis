package com.withsafe.domain;


import com.withsafe.domain.watch.domain.Watch;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@RequiredArgsConstructor
public class User {
    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String name;    //이름
    private int age;    //나이
    private String phone_num;   //전화번호
    private String emergency_contact;   //비상연락망
    private String emergency_relation;  //비상연락망 대상과의 관계
    private int heartRate_threshold;    //심박수 임계치
    private int oxygen_threshold;   //산소포화도 임계치
    private int walk_threshold; //걸음수 임계치
    private double height;  //키
    private double weight;  //몸무게

    @Enumerated(value = EnumType.STRING)
    private Sex sex;    //성별

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private Watch watch;    //매핑된 워치 id

    //FK
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;  //해당 사용자가 포함된 부서 id

    @Builder
    public User(Long id, String name, int age, String phone_num, String emergency_contact, String emergency_relation, int heartRate_threshold, int oxygen_threshold, int walk_threshold, double height, double weight, Sex sex, Watch watch, Department department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone_num = phone_num;
        this.emergency_contact = emergency_contact;
        this.emergency_relation = emergency_relation;
        this.heartRate_threshold = heartRate_threshold;
        this.oxygen_threshold = oxygen_threshold;
        this.walk_threshold = walk_threshold;
        this.height = height;
        this.weight = weight;
        this.sex = sex;
        this.watch = watch;
        this.department = department;
    }
}
