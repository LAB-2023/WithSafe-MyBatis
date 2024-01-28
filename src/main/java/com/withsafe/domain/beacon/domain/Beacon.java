package com.withsafe.domain.beacon.domain;

import com.withsafe.domain.beacon.dto.BeaconResponseDto;
import com.withsafe.domain.indoorEntrance.domain.IndoorEntrance;
import com.withsafe.domain.indoorMap.domain.IndoorMap;
import com.withsafe.global.BaseTimeDomain;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.PrecisionModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class Beacon extends BaseTimeDomain {

    @Id @GeneratedValue
    @Column(name = "beacon_id")
    private Long id;

    //private LocalDateTime date; //설치된 시간
    private String status;  //수신/미수신 상태

    @Enumerated(EnumType.STRING)
    private BeaconType beaconType;

    //FK
    private IndoorMap indoorMap;    //비콘이 설치된 실내지도 id

    private List<IndoorEntrance> indoorEntranceList = new ArrayList<>();

    @Column(columnDefinition = "geometry(Point, 4326)")
    private Point coordinate;

    private String macAddress;

    // == 연관관계 편의 메서드 == //
    public void setIndoorMap(IndoorMap indoorMap) {
        this.indoorMap = indoorMap;
        indoorMap.getBeaconList().add(this);
    }

    @Builder
    public Beacon(Long id, String status, BeaconType beaconType, IndoorMap indoorMap, List<IndoorEntrance> indoorEntranceList, Point coordinate, String macAddress) {
        this.id = id;
        this.status = status;
        this.beaconType = beaconType;
        this.indoorMap = indoorMap;
        this.indoorEntranceList = indoorEntranceList;
        this.coordinate = coordinate;
        this.macAddress = macAddress;
    }

    public static Beacon toEntity(BeaconResponseDto beaconResponseDto){
        Point point = getPoint(beaconResponseDto.getCoordinate_x(), beaconResponseDto.getCoordinate_y());
        return Beacon
                .builder()
                .id(beaconResponseDto.getId())
                .coordinate(point)
                .macAddress(beaconResponseDto.getMacAddress())
                .status(beaconResponseDto.getStatus())
                .build();
    }

    private static Point getPoint(double x, double y){
        GeometryFactory geometryFactory;
        geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);
        return geometryFactory.createPoint(new Coordinate(x, y));
    }
}