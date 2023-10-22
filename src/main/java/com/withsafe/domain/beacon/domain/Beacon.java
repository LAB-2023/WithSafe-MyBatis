package com.withsafe.domain.beacon.domain;

import com.withsafe.domain.BaseTimeEntity;
import com.withsafe.domain.indoorEntrance.domain.IndoorEntrance;
import com.withsafe.domain.indoorMap.domain.IndoorMap;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Point;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@RequiredArgsConstructor
public class Beacon extends BaseTimeEntity {

    @Id @GeneratedValue
    @Column(name = "beacon_id")
    private Long id;

    //private LocalDateTime date; //설치된 시간
    private String status;  //수신/미수신 샅태

    //FK
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "indoor_map_id")
    private IndoorMap indoorMap;    //비콘이 설치된 실내지도 id

    @OneToMany(mappedBy = "beacon", fetch = FetchType.LAZY)
    private List<IndoorEntrance> indoorEntranceList = new ArrayList<>();

    // == 연관관계 편의 메서드 == //
    public void setIndoorMap(IndoorMap indoorMap) {
        this.indoorMap = indoorMap;
        indoorMap.getBeaconList().add(this);
    }

    @Builder
    public Beacon(Long id, String status, IndoorMap indoorMap, List<IndoorEntrance> indoorEntranceList) {
        this.id = id;
        this.status = status;
        this.indoorMap = indoorMap;
        this.indoorEntranceList = indoorEntranceList;
    }
}