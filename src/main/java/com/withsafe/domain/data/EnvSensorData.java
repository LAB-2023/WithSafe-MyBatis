package com.withsafe.domain.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class EnvSensorData {
    @Id @GeneratedValue
    private Long id;

    private LocalDateTime reg_dt;

    private Double PM10;
    private Double PM25;
    private Double PM40;
    private Double PM100;
    private Double Co2;
    private Double Tvoc;
    private Double No2;
    private Double So2;
    private Double Co;
    private Double O2;
    private Double H2S;
    private Double CH4;
    private Double temperature;
    private Double humidity;
}
