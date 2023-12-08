package com.withsafe.domain.restrictArea.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.withsafe.domain.indoorMap.domain.IndoorMap;
import com.withsafe.domain.outdoorMap.domain.OutdoorMap;
import com.withsafe.domain.restrictArea.domain.RestrictArea;
import lombok.Builder;
import lombok.Getter;
import org.locationtech.jts.geom.Point;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class RestrictAreaDto {

    @Getter
    @Builder
    public static class SaveRequest{
        private String mapName;
        private String areaName;
        private String safetyRule;
        private Double coordinate_left_x;
        private Double coordinate_left_y;
        private Double coordinate_right_x;
        private Double coordinate_right_y;

        public RestrictArea toEntity(Point coordinate_left, Point coordinate_Right,
                                     IndoorMap indoorMap, OutdoorMap outdoorMap){
            return RestrictArea.builder()
                    .name(this.areaName)
                    .coordinate_left(coordinate_left)
                    .coordinate_right(coordinate_Right)
                    .safetyRule(this.safetyRule)
                    .indoorMap(indoorMap)
                    .outdoorMap(outdoorMap)
                    .build();
        }
    }






}
