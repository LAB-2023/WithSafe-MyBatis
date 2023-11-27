package com.withsafe.domain.env.dto;

import com.withsafe.domain.env.domain.EnvSensor;
import com.withsafe.domain.outdoorMap.domain.OutdoorMap;
import lombok.Builder;

import org.locationtech.jts.geom.Point;
import java.time.LocalDateTime;

public class EnvSensorDTO {
    public static class SaveRequest {
        private Point coordinate;
        private String serialNum;   //시리얼번호
        private LocalDateTime openingDate;  //개통일
        private String model;   //모델 정보
        private Boolean isUsed; //사용여부
        private OutdoorMap outdoorMap;  //설치된 실외지도 id

        @Builder
        public SaveRequest(Point coordinate, String serialNum, LocalDateTime openingDate, String model, Boolean isUsed, OutdoorMap outdoorMap) {
            this.coordinate = coordinate;
            this.serialNum = serialNum;
            this.openingDate = openingDate;
            this.model = model;
            this.isUsed = isUsed;
            this.outdoorMap = outdoorMap;
        }

        public EnvSensor toSaveEntity() {
            return EnvSensor.builder()
                    .coordinate(this.coordinate)
                    .serialNum(this.serialNum)
                    .openingDate(this.openingDate)
                    .model(this.model)
                    .isUsed(this.isUsed)
                    .outdoorMap(this.outdoorMap)
                    .build();
        }

        public static SaveRequest toSaveRequestDTO(EnvSensor envSensor) {
            return SaveRequest.builder()
                    .coordinate(envSensor.getCoordinate())
                    .serialNum(envSensor.getSerialNum())
                    .openingDate(envSensor.getOpeningDate())
                    .model(envSensor.getModel())
                    .isUsed(envSensor.getIsUsed())
                    .outdoorMap(envSensor.getOutdoorMap())
                    .build();
        }

    }

    public static class FindRequest {
        private Point coordinate;
        private String serialNum;   //시리얼번호
        private LocalDateTime openingDate;  //개통일
        private String model;   //모델 정보
        private Boolean isUsed; //사용여부
        private OutdoorMap outdoorMap;  //설치된 실외지도 id

        @Builder
        public FindRequest(Point coordinate, String serialNum, LocalDateTime openingDate, String model, Boolean isUsed, OutdoorMap outdoorMap) {
            this.coordinate = coordinate;
            this.serialNum = serialNum;
            this.openingDate = openingDate;
            this.model = model;
            this.isUsed = isUsed;
            this.outdoorMap = outdoorMap;
        }

        public EnvSensor toFindEntity() {
            return EnvSensor.builder()
                    .coordinate(this.coordinate)
                    .serialNum(this.serialNum)
                    .openingDate(this.openingDate)
                    .model(this.model)
                    .isUsed(this.isUsed)
                    .outdoorMap(this.outdoorMap)
                    .build();
        }

        public static SaveRequest toFindRequestDTO(EnvSensor envSensor) {
            return SaveRequest.builder()
                    .coordinate(envSensor.getCoordinate())
                    .serialNum(envSensor.getSerialNum())
                    .openingDate(envSensor.getOpeningDate())
                    .model(envSensor.getModel())
                    .isUsed(envSensor.getIsUsed())
                    .outdoorMap(envSensor.getOutdoorMap())
                    .build();
        }

    }
}
