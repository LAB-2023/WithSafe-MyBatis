package com.withsafe.domain.env.dto;


import com.withsafe.domain.env.domain.EnvSensor;
import com.withsafe.domain.env.domain.EnvSensorData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

public class EnvSensorAndDataDTO {

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Setter
    public static class EnvSensorAndDataFindResponseDTO {
        Long id;
        String serialNum;
        Map<String,Object> envSensorData;
    }

//    public static EnvSensorAndDataDTO.EnvSensorAndDataFindResponseDTO toEnvSensorAndDataDTO(EnvSensorData envSensorData) {
//        EnvSensor envSensor =
//        return EnvSensorAndDataFindResponseDTO.builder()
//                .id(envSensorData.getId())
//                .serialNum(en).build();
//    }
}
