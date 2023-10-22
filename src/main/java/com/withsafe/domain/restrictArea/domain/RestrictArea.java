package com.withsafe.domain.restrictArea.domain;

import com.withsafe.domain.outdoorMap.domain.OutdoorMap;
import com.withsafe.domain.indoorMap.domain.IndoorMap;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Point;


import javax.persistence.*;
//import java.awt.*;

@Entity
@Getter
@RequiredArgsConstructor
public class RestrictArea {
    @Id @GeneratedValue
    @Column(name = "restrict_area_id")
    private Long id;    //PK

    private String name;    //제한구역 이름

    private String safetyRule;  //제한구역의 안전수칙

    //의존성 추가, yml 수정필요
    //import org.locationtech.jts.geom.Point 사용할 것 (awt 아님)
    private Point coordinate;   //제한구역의 중심 좌표

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "indoor_map_id")
    private IndoorMap indoorMap;    //실내에 해당되는 제한구역일 경우 실내지도의 id

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "outdoor_map_id")
    private OutdoorMap outdoorMap;  //실외에 해당되는 제한구역일 경우 실외지도의 id

    // == 연관관계 편의 메서드 == //
    public void setIndoorMap(IndoorMap indoorMap) {
        this.indoorMap = indoorMap;
        indoorMap.getRestrictAreaList().add(this);
    }

    public void setOutdoorMap(OutdoorMap outdoorMap) {
        this.outdoorMap = outdoorMap;
        outdoorMap.getRestrictAreaList().add(this);
    }
}
