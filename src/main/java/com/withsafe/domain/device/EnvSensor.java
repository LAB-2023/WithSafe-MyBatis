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

    private Point coordinate;
    private String serialNum;
    private LocalDateTime openingDate;
    private String model;
    private Boolean isUsed;

    //연관관계 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "outdoor_map_id")
    private OutdoorMap outdoorMap;

    // == 연관관계 편의 메서드 == //
    public void setOUtdoorMap(OutdoorMap outdoorMap) {
        this.outdoorMap = outdoorMap;
        outdoorMap.getEnvSensorList().add(this);
    }
}
