package com.withsafe.domain.env.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class EnvNotice {
    @Id
    @GeneratedValue
    @Column(name = "env_notice_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "env_sensor_id")
    private EnvSensor envSensor;

    @Builder
    public EnvNotice(Long id, EnvSensor envSensor) {
        this.id = id;
        this.envSensor = envSensor;
    }
}