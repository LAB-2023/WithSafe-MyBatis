package com.withsafe.domain.device;

import com.withsafe.domain.area.OutdoorMap;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.awt.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@RequiredArgsConstructor
public class EnvSensor {

    @Id @GeneratedValue
    private Long id;

    private Point coordinate;
    private String serialNum;
    private LocalDateTime openingDate;
    private String model;
    private Boolean isUsed;

    //연관관계 매핑
    @ManyToOne
    private OutdoorMap outdoorMap;
}
