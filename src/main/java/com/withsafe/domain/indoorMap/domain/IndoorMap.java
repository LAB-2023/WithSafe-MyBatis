package com.withsafe.domain.indoorMap.domain;

import com.withsafe.domain.beacon.domain.Beacon;
import com.withsafe.domain.department.domain.Department;
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

    private String uwbMapId; //uwb가 보내주는 MapId 값

    @OneToMany(mappedBy = "indoorMap")
    private List<Beacon> beaconList = new ArrayList<>();    //하나의 지도(구역)에 설치된 비콘 목록

    @OneToMany(mappedBy = "indoorMap")
    private List<RestrictArea> restrictAreaList = new ArrayList<>();    //하나의 지도(구역)에 설정되어있는 제한구역 목록

    //연관관계 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;  //지도를 포함하고 있는 부서


    /*연관관계 편의 메서드*/
    public void setDepartment(Department department) {
        this.department = department;
        department.getIndoorMapList().add(this);
    }
}