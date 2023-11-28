package com.withsafe.domain.env.domain;

import com.withsafe.domain.BaseTimeEntity;
import com.withsafe.domain.env.dto.EnvSensorDTO;
import com.withsafe.domain.outdoorMap.domain.OutdoorMap;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import org.locationtech.jts.geom.Point;
import java.time.LocalDateTime;

@Entity
@Getter
@RequiredArgsConstructor
public class EnvSensor extends BaseTimeEntity {

    @Id @GeneratedValue
    @Column(name = "env_sensor_id")
    private Long id;

    private Point coordinate;   //환경센서 설치된 좌표

    private String serialNum;   //시리얼번호
    private LocalDateTime openingDate;  //개통일
    private String model;   //모델 정보
    private Boolean isUsed; //사용여부

    //연관관계 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "outdoor_map_id")
    private OutdoorMap outdoorMap;  //설치된 실외지도 id


    @Builder
    public EnvSensor(Long id,Point coordinate, String serialNum, LocalDateTime openingDate, String model, Boolean isUsed, OutdoorMap outdoorMap) {
        this.id = id;
        this.coordinate = coordinate;
        this.serialNum = serialNum;
        this.openingDate = openingDate;
        this.model = model;
        this.isUsed = isUsed;
        this.outdoorMap = outdoorMap;
    }

    // == 연관관계 편의 메서드 == //
    public void setOutdoorMap(OutdoorMap outdoorMap) {
        this.outdoorMap = outdoorMap;
        outdoorMap.getEnvSensorList().add(this);
    }

    @Builder
    public EnvSensor(Long id, Point coordinate, String serialNum, String model, Boolean isUsed, OutdoorMap outdoorMap) {
        this.id = id;
        this.coordinate = coordinate;
        this.serialNum = serialNum;
        this.model = model;
        this.isUsed = isUsed;
        this.outdoorMap = outdoorMap;
    }

}
