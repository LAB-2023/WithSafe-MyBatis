package com.withsafe.domain.restrictArea.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.withsafe.domain.indoorMap.domain.IndoorMap;
import com.withsafe.domain.outdoorMap.domain.OutdoorMap;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Point;

import javax.persistence.*;
//import java.awt.*;

@Getter
@RequiredArgsConstructor
public class RestrictArea {

    private Long id;    //PK
    private String name;    //제한구역 이름
    private String safetyRule;  //제한구역의 안전수칙
    //의존성 추가, yml 수정필요
    //import org.locationtech.jts.geom.Point 사용할 것 (awt 아님)
    @Column(columnDefinition = "geometry(Point, 4326)")
    private Point coordinate_left;   //제한구역 좌표(왼쪽 위)
    @Column(columnDefinition = "geometry(Point, 4326)")
    private Point coordinate_right;   //제한구역 좌표(오른쪽 아래)

    @JsonIgnore
    private IndoorMap indoorMap;    //실내에 해당되는 제한구역일 경우 실내지도의 id

    @JoinColumn(name = "outdoor_map_id")
    private OutdoorMap outdoorMap;  //실외에 해당되는 제한구역일 경우 실외지도의 id

    // == 연관관계 편의 메서드 == //
    public void setIndoorMap(IndoorMap indoorMap) {
        this.indoorMap = indoorMap;
        indoorMap.getRestrictAreaList().add(this);
    }

//    public void setOutdoorMap(OutdoorMap outdoorMap) {
//        this.outdoorMap = outdoorMap;
//        outdoorMap.getRestrictAreaList().add(this);
//    }

    @Builder
    public RestrictArea(Long id, String name, String safetyRule, Point coordinate_left, Point coordinate_right,
                        IndoorMap indoorMap, OutdoorMap outdoorMap) {
        this.id = id;
        this.name = name;
        this.safetyRule = safetyRule;
        this.coordinate_left = coordinate_left;
        this.coordinate_right = coordinate_right;
        this.indoorMap = indoorMap;
        this.outdoorMap = outdoorMap;
    }
}
