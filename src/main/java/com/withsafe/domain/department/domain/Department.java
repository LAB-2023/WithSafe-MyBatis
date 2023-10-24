package com.withsafe.domain.department.domain;

import com.withsafe.domain.admin.domain.Admin;
import com.withsafe.domain.outdoorMap.domain.OutdoorMap;
import com.withsafe.domain.indoorMap.domain.IndoorMap;
import com.withsafe.domain.watch.domain.Watch;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Getter @Setter
@RequiredArgsConstructor
public class Department {

    @Id @GeneratedValue
    @Column(name = "department_id")
    private Long id;

    private String name;    //부서 이름

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @OneToMany(mappedBy = "department")
    private List<Watch> watchList = new ArrayList<>();    //부서에 포함된 유저 목록

    @OneToMany(mappedBy = "department")
    private List<OutdoorMap> outdoorMapList = new ArrayList<>();    //부서에 포함된 실외지도 목록

    @OneToMany(mappedBy = "department")
    private List<IndoorMap> indoorMapList = new ArrayList<>();  //부서에 포함된 실내지도 목록

    @Builder
    public Department(String name) {
        this.name = name;
    }
}

