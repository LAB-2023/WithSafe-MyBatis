package com.withsafe.domain.indoorMap.dto;

import com.withsafe.domain.beacon.domain.Beacon;
import com.withsafe.domain.restrictArea.domain.RestrictArea;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Point;


import java.time.LocalDateTime;
import java.util.List;

public class IndoorMapDto {
    @Builder
    @Getter
    public static class IndoorMapInfo{
        private Long id;
        private String name;
        private String URL;
        private String uwbMapId;
        private List<Beacon> beaconList;
        private List<RestrictArea> restrictAreaList;
    }

    @Getter
    @Setter
    public static class RestrictCoordinate{
        private Point coordinate;
    }

    @Builder
    @Getter
    public static class UserInfo{
        private String name;
        private String phone_num;
        private Point coordinate;
        private LocalDateTime time;
    }

    @Builder
    @Getter
    public static class AreaInfo{
        private String URL;
        private List<RestrictCoordinate> restrictCoordinate;
        private List<UserInfo> userCoordinate;

    }
}
