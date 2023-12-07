package com.withsafe.domain.user.dto;

import com.withsafe.domain.department.domain.Department;
import com.withsafe.domain.user.domain.Sex;
import com.withsafe.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

public class UserDTO {

    @Getter
    @NoArgsConstructor
    public static class SaveRequest {
        private String name;    //이름
        private int age;    //나이
        private String phoneNum;   //전화번호
        private String emergency_contact;   //비상연락망
        private String emergency_relation;  //비상연락망 대상과의 관계
        private int heartRate_threshold;    //심박수 임계치
        private int oxygen_threshold;   //산소포화도 임계치
        private int walk_threshold; //걸음수 임계치
        private double height;  //키
        private double weight;  //몸무게
        @Enumerated(value = EnumType.STRING)
        private Sex sex;    //성별
        private Integer bloodPressure_high;
        private Integer bloodPressure_low;
        private Integer diabetes;
        private Double heartDisease;
        private String departmentName;

        @Builder
        public SaveRequest(String name, int age, String phoneNum, String emergency_contact, String emergency_relation,
                           int heartRate_threshold, int oxygen_threshold, int walk_threshold, double height,
                           double weight, Sex sex, Integer bloodPressure_high, Integer bloodPressure_low,
                           Integer diabetes, Double heartDisease, String departmentName) {
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
            this.departmentName = departmentName;
        }

        public User toEntity(Department department) {
            return User.builder()
                    .name(this.name)
                    .age(this.age)
                    .phoneNum(this.phoneNum)
                    .emergency_contact(this.emergency_contact)
                    .emergency_relation(this.emergency_relation)
                    .heartRate_threshold(this.heartRate_threshold)
                    .oxygen_threshold(this.oxygen_threshold)
                    .walk_threshold(this.walk_threshold)
                    .height(this.height)
                    .weight(this.weight)
                    .sex(this.sex)
                    .bloodPressure_high(this.bloodPressure_high)
                    .bloodPressure_low(this.bloodPressure_low)
                    .diabetes(this.diabetes)
                    .heartDisease(this.heartDisease)
                    .department(department)
                    .build();
        }
    }
    @Getter
    @NoArgsConstructor
    public static class FindRequest {
        private Long id;
        private String name;    //이름
        private int age;    //나이
        private String phoneNum;   //전화번호
        private String emergency_contact;   //비상연락망
        private String emergency_relation;  //비상연락망 대상과의 관계
        private int heartRate_threshold;    //심박수 임계치
        private int oxygen_threshold;   //산소포화도 임계치
        private int walk_threshold; //걸음수 임계치
        private double height;  //키
        private double weight;  //몸무게
        @Enumerated(value = EnumType.STRING)
        private Sex sex;    //성별
        private Integer bloodPressure_high;
        private Integer bloodPressure_low;
        private Integer diabetes;
        private Double heartDisease;

        @Builder
        public FindRequest(Long id, String name, int age, String phoneNum, String emergency_contact, String emergency_relation, int heartRate_threshold, int oxygen_threshold, int walk_threshold, double height, double weight, Sex sex, Integer bloodPressure_high, Integer bloodPressure_low, Integer diabetes, Double heartDisease) {
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
        }


        public User toEntity() {
            return User.builder()
                    .id(this.id)
                    .name(this.name)
                    .age(this.age)
                    .phoneNum(this.phoneNum)
                    .emergency_contact(this.emergency_contact)
                    .emergency_relation(this.emergency_relation)
                    .heartRate_threshold(this.heartRate_threshold)
                    .oxygen_threshold(this.oxygen_threshold)
                    .walk_threshold(this.walk_threshold)
                    .height(this.height)
                    .weight(this.weight)
                    .sex(this.sex)
                    .bloodPressure_high(this.bloodPressure_high)
                    .bloodPressure_low(this.bloodPressure_low)
                    .diabetes(this.diabetes)
                    .heartDisease(this.heartDisease)
                    .build();
        }
    }
}
