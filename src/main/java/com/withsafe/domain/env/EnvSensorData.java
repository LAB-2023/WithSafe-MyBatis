package com.withsafe.domain.env;

import com.withsafe.domain.BaseTimeEntity;
import com.withsafe.domain.env.EnvSensor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@RequiredArgsConstructor
public class EnvSensorData extends BaseTimeEntity {    //환경센서에서 넘어오는 데이터
    @Id @GeneratedValue
    @Column(name = "env_sensor_data_id")
    private Long id;

    //private LocalDateTime date;

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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "env_sensor_id")
    private EnvSensor envSensor;
}
