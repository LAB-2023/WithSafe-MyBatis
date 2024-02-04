package com.withsafe.domain.user.domain;


import com.withsafe.domain.department.domain.Department;
import com.withsafe.domain.watch.domain.WatchJpa;
import com.withsafe.global.BaseTimeDomain;
import lombok.*;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static com.withsafe.domain.user.dto.UserDTO.*;

@Getter
@RequiredArgsConstructor
@Table(name = "Member")
public class User extends BaseTimeDomain {

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

    private Sex sex;    //성별

    private Integer bloodPressure_high;
    private Integer bloodPressure_low;
    private Integer diabetes;
    private Double heartDisease;

    private List<WatchJpa> watchList = new ArrayList<>();

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
        return FindRequest
                .builder()
                .id(id)
                .name(name)
                .age(age)
                .phoneNum(phoneNum)
                .emergency_contact(emergency_contact)
                .emergency_relation(emergency_relation)
                .heartDisease(heartDisease)
                .bloodPressure_high(bloodPressure_high)
                .bloodPressure_low(bloodPressure_low)
                .diabetes(diabetes)
                .heartRate_threshold(heartRate_threshold)
                .height(height)
                .weight(weight)
                .oxygen_threshold(oxygen_threshold)
                .sex(sex)
                .walk_threshold(walk_threshold)
                .build();
    }

    public void update(SaveRequest request) {
        this.name = request.getName();
        this.age = request.getAge();
        this.phoneNum = request.getPhoneNum();
        this.emergency_contact = request.getEmergency_contact();
        this.emergency_relation = request.getEmergency_relation();
        this.heartRate_threshold = request.getHeartRate_threshold();
        this.oxygen_threshold = request.getOxygen_threshold();
        this.walk_threshold = request.getWalk_threshold();
        this.height = request.getHeight();
        this.weight = request.getWeight();
        this.sex = request.getSex();
        this.bloodPressure_high = request.getBloodPressure_high();
        this.bloodPressure_low = request.getBloodPressure_low();
    }
}
