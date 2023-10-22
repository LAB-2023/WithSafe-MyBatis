package com.withsafe.domain.user.domain;


import com.withsafe.domain.BaseTimeEntity;
import com.withsafe.domain.department.domain.Department;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static com.withsafe.domain.user.dto.UserDTO.*;

@Entity
@Getter @Setter
@RequiredArgsConstructor
public class User extends BaseTimeEntity {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String name;    //이름
    private Integer age;    //나이
    private String phone_num;   //전화번호
    private String emergency_contact;   //비상연락망
    private String emergency_relation;  //비상연락망 대상과의 관계
    private Integer heartRate_threshold;    //심박수 임계치
    private Integer oxygen_threshold;   //산소포화도 임계치
    private Integer walk_threshold; //걸음수 임계치
    private Double height;  //키
    private Double weight;  //몸무게

    @Enumerated(value = EnumType.STRING)
    private Sex sex;    //성별

    //FK
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;  //해당 사용자가 포함된 부서 id

    @Builder
    public User(Long id, String name, Integer age, String phone_num, String emergency_contact, String emergency_relation, Integer heartRate_threshold, Integer oxygen_threshold, Integer walk_threshold, Double height, Double weight, Sex sex, Department department) {
//        this.id = id;
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
        this.department = department;
    }

    public SaveRequest toUserSaveRequestDTO() {
        return new SaveRequest(this.name,this.age,this.phone_num,this.emergency_contact,this.emergency_relation, this.heartRate_threshold, this.oxygen_threshold,this.walk_threshold,this.height,this.weight,this.sex);
    }
    public FindRequest toUserFindRequestDTO() {
        return new FindRequest(this.name,this.age,this.phone_num,this.emergency_contact,this.emergency_relation, this.heartRate_threshold, this.oxygen_threshold,this.walk_threshold,this.height,this.weight,this.sex);
    }

    public User(String name, Integer age, String phone_num, String emergency_contact, String emergency_relation, Integer heartRate_threshold, Integer oxygen_threshold, Integer walk_threshold, Double height, Double weight, Sex sex, Department department) {
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
        this.department = department;
    }
}
