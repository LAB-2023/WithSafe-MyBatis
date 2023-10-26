package com.withsafe.domain.env.domain;

import com.withsafe.domain.BaseTimeEntity;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Getter
@RequiredArgsConstructor
@TypeDef(name = "json", typeClass = JsonType.class)
public class EnvSensorData extends BaseTimeEntity {

    @Id @GeneratedValue
    @Column(name = "env_sensor_data_id")
    private Long id;

    // 연관관계 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "env_sensor_id")
    private EnvSensor envSensor;

    @Column(name = "asset_code")
    private String assetCode;
    private String device;
    private Float version;
    private String name;

    @Type(type = "io.hypersistence.utils.hibernate.type.json.JsonType")
    @Column(columnDefinition = "json")
    private Map<String, Object> dataValues = new HashMap<>();

    @Builder
    public EnvSensorData(Long id, EnvSensor envSensor, String assetCode, String device, Float version, String name, Map<String, Object> dataValues) {
        this.id = id;
        this.envSensor = envSensor;
        this.assetCode = assetCode;
        this.device = device;
        this.version = version;
        this.name = name;
        this.dataValues = dataValues;
    }

    public EnvSensorData(Map<String, Object> dataValues) {
        this.dataValues = dataValues;
    }
}
