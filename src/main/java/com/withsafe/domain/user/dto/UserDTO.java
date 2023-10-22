package com.withsafe.domain.user.dto;

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

        @Builder
        public SaveRequest(String name, int age, String phone_num, String emergency_contact, String emergency_relation, int heartRate_threshold, int oxygen_threshold, int walk_threshold, double height, double weight, Sex sex) {
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
        }

        public User toEntity() {
            return User.builder()
                    .name(this.name)
                    .age(this.age)
                    .phone_num(this.phone_num)
                    .emergency_contact(this.emergency_contact)
                    .emergency_relation(this.emergency_relation)
                    .heartRate_threshold(this.heartRate_threshold)
                    .oxygen_threshold(this.oxygen_threshold)
                    .walk_threshold(this.walk_threshold)
                    .height(this.height)
                    .weight(this.weight)
                    .sex(this.sex)
                    .build();
        }
    }
    @Getter
    @NoArgsConstructor
    public static class FindRequest {
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

        @Builder
        public FindRequest(String name, int age, String phone_num, String emergency_contact, String emergency_relation, int heartRate_threshold, int oxygen_threshold, int walk_threshold, double height, double weight, Sex sex) {
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
        }

        public User toEntity() {
            return User.builder()
                    .name(this.name)
                    .age(this.age)
                    .phone_num(this.phone_num)
                    .emergency_contact(this.emergency_contact)
                    .emergency_relation(this.emergency_relation)
                    .heartRate_threshold(this.heartRate_threshold)
                    .oxygen_threshold(this.oxygen_threshold)
                    .walk_threshold(this.walk_threshold)
                    .height(this.height)
                    .weight(this.weight)
                    .sex(this.sex)
                    .build();
        }
    }
}