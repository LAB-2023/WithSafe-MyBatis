package com.withsafe.domain.department.domain;

import com.withsafe.domain.outdoorMap.domain.OutdoorMap;
import com.withsafe.domain.indoorMap.domain.IndoorMap;
import com.withsafe.domain.watch.domain.WatchJpa;
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
public class DepartmentJpa {

    @Id @GeneratedValue
    @Column(name = "department_id")
    private Long id;

    private String name;    //부서 이름

    @OneToMany(mappedBy = "departmentJpa")
    private List<WatchJpa> watchList = new ArrayList<>();    //부서에 포함된 유저 목록

    @OneToMany(mappedBy = "departmentJpa")
    private List<OutdoorMap> outdoorMapList = new ArrayList<>();    //부서에 포함된 실외지도 목록

    @OneToMany(mappedBy = "departmentJpa")
    private List<IndoorMap> indoorMapList = new ArrayList<>();  //부서에 포함된 실내지도 목록

    @Builder
    public DepartmentJpa(String name) {
        this.name = name;
    }

    public boolean containsIndoorMap(String mapName) {
        if (indoorMapList != null) {
            for (IndoorMap indoorMap : indoorMapList) {
                if (indoorMap.getName().equals(mapName)) {
                    return true;
                }
            }
        }
        return false;
    }
}

