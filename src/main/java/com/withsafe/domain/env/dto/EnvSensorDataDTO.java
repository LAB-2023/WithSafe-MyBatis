package com.withsafe.domain.env.dto;

import com.withsafe.domain.env.domain.EnvSensor;
import com.withsafe.domain.env.domain.EnvSensorData;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

public class EnvSensorDataDTO {

    @Getter
    public static class FindRequest {

        private Map<String, Object> dataValues;
        private EnvSensor envSensor;

        @Builder
        public FindRequest(Map<String, Object> dataValues, EnvSensor envSensor) {
            this.dataValues = dataValues;
            this.envSensor = envSensor;
        }


        public EnvSensorData toEntity() {
            return EnvSensorData.builder()
                    .dataValues(this.dataValues)
                    .envSensor(this.envSensor)
                    .build();
        }

        public static FindRequest toFindRequest(EnvSensorData envSensorData) {
            return FindRequest.builder()
                    .dataValues(envSensorData.getDataValues())
                    .envSensor(envSensorData.getEnvSensor())
                    .build();
        }
    }

}
