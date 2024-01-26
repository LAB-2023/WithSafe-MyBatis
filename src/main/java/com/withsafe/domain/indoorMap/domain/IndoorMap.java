package com.withsafe.domain.indoorMap.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.withsafe.domain.beacon.domain.Beacon;
import com.withsafe.domain.department.domain.DepartmentJpa;
import com.withsafe.domain.restrictArea.domain.RestrictArea;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@RequiredArgsConstructor
public class IndoorMap {

    @Id @GeneratedValue
    @Column(name = "indoor_map_id")
    private Long id;

    private String name;

    private String imageUrl;

    @OneToMany(mappedBy = "indoorMap" )
    private List<Beacon> beaconList = new ArrayList<>();    //하나의 지도(구역)에 설치된 비콘 목록

    @OneToMany(mappedBy = "indoorMap")
    @JsonIgnore
    private List<RestrictArea> restrictAreaList = new ArrayList<>();    //하나의 지도(구역)에 설정되어있는 제한구역 목록

    //연관관계 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private DepartmentJpa departmentJpa;  //지도를 포함하고 있는 부서


    /*연관관계 편의 메서드*/
    public void setDepartmentJpa(DepartmentJpa departmentJpa) {
        this.departmentJpa = departmentJpa;
        departmentJpa.getIndoorMapList().add(this);
    }

    @Builder
    public IndoorMap(Long id, String name, String imageUrl, List<Beacon> beaconList, List<RestrictArea> restrictAreaList, DepartmentJpa departmentJpa) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.beaconList = beaconList;
        this.restrictAreaList = restrictAreaList;
        this.departmentJpa = departmentJpa;
    }
}