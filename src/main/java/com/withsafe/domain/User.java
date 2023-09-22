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

    @OneToOne(mappedBy = "watch", fetch = FetchType.LAZY)
    private Watch watch;    //매핑된 워치 id

    //FK
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;  //해당 사용자가 포함된 부서 id

    // == 연관관계 편의 메서드 == //
    public void setDepartment(Department department) {
        this.department = department;
        department.getUserList().add(this);
    }
}
