package com.withsafe.domain.data;

import com.withsafe.domain.device.EnvSensor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@RequiredArgsConstructor
public class EnvSensorData {
    @Id @GeneratedValue
    private Long id;

    private LocalDateTime date;

    private Double PM010;
    private Double PM025;
    private Double PM040;
    private Double PM100;
    private Double CH2;
    private Double TVOC;
    private Double NO2;
    private Double SO2;
    private Double CO;
    private Double O2;
    private Double H2S;
    private Double CH4;
    private Double temperature;
    private Double humidity;

    //연관관계 매핑
    @ManyToOne
    private EnvSensor envSensor;
}
