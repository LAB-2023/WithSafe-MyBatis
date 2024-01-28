package com.withsafe.domain.beacon.dto;

import com.withsafe.domain.beacon.domain.Beacon;
import com.withsafe.domain.beacon.domain.BeaconType;
import com.withsafe.domain.indoorMap.domain.IndoorMap;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

public class BeaconDto {

    @Getter
    @NoArgsConstructor
    public static class RequestSave{
        private Double coordinate_x;
        private Double coordinate_y;
        private String status;
        private BeaconType beaconType;
        private String indoorMapName;
        private String macAddress;

        @Builder
        public RequestSave(Double coordinate_x, Double coordinate_y, String status,
                           BeaconType beaconType, String indoorMapName, String macAddress) {
            this.coordinate_x = coordinate_x;
            this.coordinate_y = coordinate_y;
            this.status = status;
            this.beaconType = beaconType;
            this.indoorMapName = indoorMapName;
            this.macAddress = macAddress;
        }

        public Beacon toEntity(IndoorMap indoorMap, Point point){
            return Beacon.builder()
                    .coordinate(point)
                    .status(this.status)
                    .indoorMap(indoorMap)
                    .beaconType(beaconType)
                    .macAddress(macAddress)
                    .build();
        }
    }
}
