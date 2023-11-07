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

    @Getter
    @Builder
    public static class RestrictCoordinate{
        private Point coordinate_left;
        private Point coordinate_right;
    }

    @Getter
    @Builder
    public static class BeaconCoordinate{
        private Point coordinate;
    }

    @Getter
    public static class IndoorMapInfo{
        private Long id;
        private String name;
        private String URL;
        private List<RestrictCoordinate> RestrictCoordinateList;
        private List<BeaconCoordinate> BeaconCoordinateList;

        @Builder
        public IndoorMapInfo(Long id, String name, String URL, List<RestrictCoordinate> restrictCoordinateList, List<BeaconCoordinate> beaconCoordinateList) {
            this.id = id;
            this.name = name;
            this.URL = URL;
            RestrictCoordinateList = new ArrayList<>();
            BeaconCoordinateList = new ArrayList<>();
        }
    }

    @Builder
    @Getter
    public static class UserLocationInfo{
        private String name;
        private String phone_num;
        private Point coordinate;
        //private LocalDateTime time;
    }

    @Getter
    @Builder
    public static class SearchCondition{
        private String userName;
        private Integer deviceNum;
    }


//    @Builder
//    @Getter
//    public static class AreaInfo{
//        private String URL;
//        private List<RestrictCoordinate> restrictCoordinate;
//        private List<UserInfo> userCoordinate;
//
//    }
}
