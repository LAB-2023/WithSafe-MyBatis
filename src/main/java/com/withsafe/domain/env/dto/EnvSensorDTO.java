package com.withsafe.domain.env.dto;

import com.withsafe.domain.env.domain.EnvSensor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

public class EnvSensorDTO {

    @Getter
    public static class EnvSensorSaveRequestDTO {
        private String serialNum;   //시리얼번호
        private LocalDateTime openingDate;  //개통일
        private String model;   //모델 정보
        private Boolean isUsed; //사용여부
    }
    public static EnvSensor toEnvSensor(EnvSensorSaveRequestDTO request) {
        return EnvSensor.builder()
                .serialNum(request.getSerialNum())
                .openingDate(request.getOpeningDate())
                .model(request.getModel())
                .isUsed(request.getIsUsed())
                .build();
    }

    @Builder
    @Getter
    @AllArgsConstructor
    @RequiredArgsConstructor
    public static class EnvSensorSaveResponseDTO {
        private Long id;
        private LocalDateTime createdAt;

    }

    public static EnvSensorSaveResponseDTO toEnvSensorSaveResponseDTO(EnvSensor envSensor) {
        return EnvSensorSaveResponseDTO.builder()
                .id(envSensor.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    @Builder
    @Getter
    @AllArgsConstructor
    @RequiredArgsConstructor
    public static class EnvSensorFindResponseDTO {
        private Long id;
        private String serialNum;
    }

    public static EnvSensorFindResponseDTO toEnvSensorFindResponseDTO(EnvSensor envSensor) {
        return EnvSensorFindResponseDTO.builder()
                .id(envSensor.getId())
                .serialNum(envSensor.getSerialNum())
                .build();
    }
}
