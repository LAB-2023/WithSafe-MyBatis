package com.withsafe.domain.user.domain;


import com.withsafe.domain.BaseTimeEntity;
import com.withsafe.domain.department.domain.Department;
import com.withsafe.domain.watch.domain.Watch;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static com.withsafe.domain.user.dto.UserDTO.*;

@Entity
@Getter @Setter
@RequiredArgsConstructor
@Table(name = "Member")
public class User extends BaseTimeEntity {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String name;    //이름
    private Integer age;    //나이
    private String phoneNum;   //전화번호
    private String emergency_contact;   //비상연락망
    private String emergency_relation;  //비상연락망 대상과의 관계
    private Integer heartRate_threshold;    //심박수 임계치
    private Integer oxygen_threshold;   //산소포화도 임계치
    private Integer walk_threshold; //걸음수 임계치
    private Double height;  //키
    private Double weight;  //몸무게

    @Enumerated(value = EnumType.STRING)
    private Sex sex;    //성별

    private Integer bloodPressure_high;
    private Integer bloodPressure_low;
    private Integer diabetes;
    private Double heartDisease;

    //FK
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Watch> watchList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;


    @Builder
    public User(Long id, String name, Integer age, String phoneNum, String emergency_contact, String emergency_relation,
                Integer heartRate_threshold, Integer oxygen_threshold, Integer walk_threshold, Double height,
                Double weight, Sex sex, Integer bloodPressure_high, Integer bloodPressure_low, Integer diabetes,
                Double heartDisease, Department department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phoneNum = phoneNum;
        this.emergency_contact = emergency_contact;
        this.emergency_relation = emergency_relation;
        this.heartRate_threshold = heartRate_threshold;
        this.oxygen_threshold = oxygen_threshold;
        this.walk_threshold = walk_threshold;
        this.height = height;
        this.weight = weight;
        this.sex = sex;
        this.bloodPressure_high = bloodPressure_high;
        this.bloodPressure_low = bloodPressure_low;
        this.diabetes = diabetes;
        this.heartDisease = heartDisease;
        this.department = department;
    }

    public SaveRequest toUserSaveRequestDTO() {
        return new SaveRequest(this.name,this.age,this.phoneNum,this.emergency_contact,this.emergency_relation, this.heartRate_threshold, this.oxygen_threshold,this.walk_threshold,this.height,this.weight,this.sex,this.bloodPressure_high,this.bloodPressure_low,this.diabetes,this.heartDisease, this.department.getName());
    }
    public FindRequest toUserFindRequestDTO() {
        return new FindRequest(this.id, this.name,this.age,this.phoneNum,this.emergency_contact,this.emergency_relation, this.heartRate_threshold, this.oxygen_threshold,this.walk_threshold,this.height,this.weight,this.sex,this.bloodPressure_high,this.bloodPressure_low,this.diabetes,this.heartDisease);
    }

//    public User(String name, Integer age, String phoneNum, String emergency_contact, String emergency_relation, Integer heartRate_threshold, Integer oxygen_threshold, Integer walk_threshold, Double height, Double weight, Sex sex) {
//        this.name = name;
//        this.age = age;
//        this.phoneNum = phoneNum;
//        this.emergency_contact = emergency_contact;
//        this.emergency_relation = emergency_relation;
//        this.heartRate_threshold = heartRate_threshold;
//        this.oxygen_threshold = oxygen_threshold;
//        this.walk_threshold = walk_threshold;
//        this.height = height;
//        this.weight = weight;
//        this.sex = sex;
//    }
}
