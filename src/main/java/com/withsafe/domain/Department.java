package com.withsafe.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Getter @Setter
public class Department {

    @Id @GeneratedValue
    @Column(name = "department_id")
    private Long id;

    private String name;    //부서 이름

    @OneToMany(mappedBy = "department")
    private List<User> userList = new ArrayList<>();    //부서에 포함된 유저 목록

    @OneToMany(mappedBy = "department")
    private List<OutdoorMap> outdoorMapList = new ArrayList<>();    //부서에 포함된 실외지도 목록

    @OneToMany(mappedBy = "department")
    private List<IndoorMap> indoorMapList = new ArrayList<>();  //부서에 포함된 실내지도 목록
}

