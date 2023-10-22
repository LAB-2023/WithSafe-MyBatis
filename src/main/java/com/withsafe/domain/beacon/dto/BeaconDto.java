package com.withsafe.domain.beacon.dto;

import com.withsafe.domain.beacon.domain.Beacon;
import com.withsafe.domain.indoorMap.domain.IndoorMap;
import com.withsafe.domain.notice.dto.NoticeEmergencyContactDto;
import com.withsafe.domain.warning.domain.WarningMessage;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;

public class BeaconDto {

    @Getter
    @NoArgsConstructor
    public static class RequestSave{
        private Point coordinate;
        private String status;
        private String indoorMapName;

        @Builder
        public RequestSave(String status, String indoorMapName) {
            this.status = status;
            this.indoorMapName = indoorMapName;
        }

        public Beacon toEntity(IndoorMap indoorMap){
            return Beacon.builder()
                    .status(this.status)
                    .indoorMap(indoorMap)
                    .build();
        }
    }
}
