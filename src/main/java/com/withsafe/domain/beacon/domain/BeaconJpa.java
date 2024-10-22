package com.withsafe.domain.beacon.domain;

import com.withsafe.domain.BaseTimeEntity;
import com.withsafe.domain.indoorEntrance.domain.IndoorEntranceJpa;
import com.withsafe.domain.indoorMap.domain.IndoorMapJpa;
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
public class BeaconJpa extends BaseTimeEntity {

    @Id @GeneratedValue
    @Column(name = "beacon_id")
    private Long id;

    //private LocalDateTime date; //설치된 시간
    private String status;  //수신/미수신 상태

    @Enumerated(EnumType.STRING)
    private BeaconType beaconType;

    //FK
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "indoor_map_id")
    private IndoorMapJpa indoorMap;    //비콘이 설치된 실내지도 id

    @OneToMany(mappedBy = "beacon", fetch = FetchType.LAZY)
    private List<IndoorEntranceJpa> indoorEntranceList = new ArrayList<>();

    @Column(columnDefinition = "geometry(Point, 4326)")
    private Point coordinate;

    private String macAddress;

    // == 연관관계 편의 메서드 == //
    public void setIndoorMap(IndoorMapJpa indoorMap) {
        this.indoorMap = indoorMap;
        indoorMap.getBeaconList().add(this);
    }

    @Builder
    public BeaconJpa(Long id, String status, BeaconType beaconType, IndoorMapJpa indoorMap, List<IndoorEntranceJpa> indoorEntranceList, Point coordinate, String macAddress) {
        this.id = id;
        this.status = status;
        this.beaconType = beaconType;
        this.indoorMap = indoorMap;
        this.indoorEntranceList = indoorEntranceList;
        this.coordinate = coordinate;
        this.macAddress = macAddress;
    }
}