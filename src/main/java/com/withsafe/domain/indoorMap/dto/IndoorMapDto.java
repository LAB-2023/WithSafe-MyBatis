package com.withsafe.domain.indoorMap.dto;

import com.withsafe.domain.beacon.domain.Beacon;
import com.withsafe.domain.restrictArea.domain.RestrictArea;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Point;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class IndoorMapDto {

    //해당 부서의 실내 지도를 저장하는 클래스
    //실내 지도의 디테일한 정보 x, 실내 지도에 뭐가 있는지
    //ex. ai관 3층, ai관 4층, 가천관 3층
    @Builder
    @Getter
    public static class IndoorMapInfo {
        private Long id;
        private String name;
        private String imageURL;

        public static IndoorMapInfo toIndoorMapInfo(Long id, String name, String imageURL) {
            return IndoorMapInfo.builder()
                    .id(id)
                    .name(name)
                    .imageURL(imageURL)
                    .build();
        }
    }

    //특정 실내 지도에 대한 디테일한 정보
    @Builder
    @Getter
    public static class IndoorMapLocationInfo{

        private String departmentName;
        private Long indoorMapId;
        private Long restrictAreaId;
        private Point restrictAreaCoordinateLeft;
        private Point restrictAreaCoordinateRight;
        private Long beaconId;
        private Point beaconCoordinate;
        private Long indoorEntranceId;
        private Long watchId;
        private Long userId;
        private String userName;
        private String phoneNum;

        public static IndoorMapLocationInfo toIndoorMapLocationInfo(String departmentName,Long indoorMapId,                                                                    Long restrictAreaId, Point restrictAreaCoordinateLeft, Point restrictAreaCoordinateRight,
                                     Long beaconId, Point beaconCoordinate,
                                     Long indoorEntranceId, Long watchId,
                                     Long userId, String userName, String phoneNum) {

            return IndoorMapLocationInfo.builder()
                        .departmentName(departmentName)
                        .indoorMapId(indoorMapId)
                        .restrictAreaId(restrictAreaId)
                        .restrictAreaCoordinateLeft(restrictAreaCoordinateLeft)
                        .restrictAreaCoordinateRight(restrictAreaCoordinateRight)
                        .beaconId(beaconId)
                        .beaconCoordinate(beaconCoordinate)
                        .indoorEntranceId(indoorEntranceId)
                        .watchId(watchId)
                        .userName(userName)
                        .phoneNum(phoneNum)
                        .build();
        }
    }

    @Getter
    @Builder
    public static class SearchCondition{
        private String departmentName;
        private String userName;
        private Integer deviceNum;
    }


}
