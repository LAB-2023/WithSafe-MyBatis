package com.withsafe.domain.device;

import com.withsafe.domain.area.OutdoorMap;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.awt.*;
import java.time.LocalDateTime;

@Entity
@Getter
@RequiredArgsConstructor
public class EnvSensor {

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

    // == 연관관계 편의 메서드 == //
    public void setOUtdoorMap(OutdoorMap outdoorMap) {
        this.outdoorMap = outdoorMap;
        outdoorMap.getEnvSensorList().add(this);
    }
}
