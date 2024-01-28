package com.withsafe.domain.department.domain;

import com.withsafe.domain.indoorMap.domain.IndoorMap;
import com.withsafe.domain.indoorMap.domain.IndoorMapJpa;
import com.withsafe.domain.outdoorMap.domain.OutdoorMap;
import com.withsafe.domain.watch.domain.Watch;
import lombok.*;

import java.util.List;
import java.util.ArrayList;

@Getter
@RequiredArgsConstructor
public class Department {


    private Long id;

    private String name;    //부서 이름

    private List<Watch> watchList = new ArrayList<>();    //부서에 포함된 유저 목록

    private List<OutdoorMap> outdoorMapList = new ArrayList<>();    //부서에 포함된 실외지도 목록

    private List<IndoorMap> indoorMapList = new ArrayList<>();  //부서에 포함된 실내지도 목록

    @Builder
    public Department(Long id, String name) {
        this.id = id;
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

