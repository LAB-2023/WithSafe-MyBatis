package com.withsafe.domain.beacon.domain;


import com.withsafe.domain.BaseTimeEntity;
import com.withsafe.domain.indoorMap.domain.IndoorMap;
import lombok.Getter;

import javax.persistence.*;
import java.awt.*;

@Entity
@Getter
public class Beacon extends BaseTimeEntity {

    @Id @GeneratedValue
    @Column(name = "beacon_id")
    private Long id;

    private Point coordinate;   //비콘이 설치된 좌표
    //private LocalDateTime date; //설치된 시간
    private String status;  //수신/미수신 샅태

    //FK
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "indoor_map_id")
    private IndoorMap indoorMap;    //비콘이 설치된 실내지도 id

    // == 연관관계 편의 메서드 == //
    public void setIndoorMap(IndoorMap indoorMap) {
        this.indoorMap = indoorMap;
        indoorMap.getBeaconList().add(this);
    }
}
