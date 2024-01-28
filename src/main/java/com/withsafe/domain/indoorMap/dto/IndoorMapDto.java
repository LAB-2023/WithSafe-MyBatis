package com.withsafe.domain.indoorMap.dto;

import com.withsafe.domain.indoorMap.domain.IndoorMap;
import lombok.Builder;
import lombok.Getter;
import org.locationtech.jts.geom.Point;

public class IndoorMapDto {

    //해당 부서의 실내 지도를 저장하는 클래스
    //실내 지도의 디테일한 정보 x, 실내 지도에 뭐가 있는지
    //ex. ai관 3층, ai관 4층, 가천관 3층
    @Builder
    @Getter
    public static class IndoorMapSaveDto {
        private String name;
        private String imageURL;
    }

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

    @Getter
    @Builder
    public static class SearchCondition{
        private String departmentName;
        private Long indoorMapId;
        private String userName;
        private Integer deviceNum;

        public static SearchCondition toSearchCondition(String departmentName, Long indoorMapId, String userName, Integer deviceNum) {
            return SearchCondition.builder()
                    .departmentName(departmentName)
                    .indoorMapId(indoorMapId)
                    .userName(userName)
                    .deviceNum(deviceNum)
                    .build();
        }
    }
}
