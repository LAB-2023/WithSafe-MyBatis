package com.withsafe.domain.indoorMap.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.withsafe.domain.beacon.domain.Beacon;
import com.withsafe.domain.department.domain.Department;
import com.withsafe.domain.restrictArea.domain.RestrictArea;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static com.withsafe.domain.indoorMap.dto.IndoorMapDto.*;

@Getter
@RequiredArgsConstructor
public class IndoorMap {

    private Long id;

    private String name;

    private String imageUrl;

    private List<Beacon> beaconList = new ArrayList<>();    //하나의 지도(구역)에 설치된 비콘 목록

    @JsonIgnore
    private List<RestrictArea> restrictAreaList = new ArrayList<>();    //하나의 지도(구역)에 설정되어있는 제한구역 목록

    //연관관계 매핑
    private Department department;  //지도를 포함하고 있는 부서


    /*연관관계 편의 메서드*/
    public void setDepartment(Department department) {
        this.department = department;
        department.getIndoorMapList().add(this);
    }

    public static IndoorMap toEntity(IndoorMapSaveDto indoorMapSaveDto, Department department) {
        return IndoorMap.builder()
                .name(indoorMapSaveDto.getName())
                .imageUrl(indoorMapSaveDto.getImageURL())
                .department(department)
                .build();
    }

    @Builder
    public IndoorMap(Long id, String name, String imageUrl, List<Beacon> beaconList,
                     List<RestrictArea> restrictAreaList, Department department) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.beaconList = beaconList;
        this.restrictAreaList = restrictAreaList;
        this.department = department;
    }
}