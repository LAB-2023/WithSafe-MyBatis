package com.withsafe.domain.restrictArea.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;

import javax.persistence.Column;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RestrictInfoDto {

    private Long restrictId;
    private Double coordinate_left_x;
    private Double coordinate_left_y;
    private Double coordinate_right_x;
    private Double coordinate_right_y;
//    @Column(columnDefinition = "geometry(Point, 4326)")
//    private Point coordinateLeft;   //제한구역 좌표(왼쪽 위)
//    @Column(columnDefinition = "geometry(Point, 4326)")
//    private Point coordinateRight;   //제한구역 좌표(오른쪽 아래)
    private String restrictAreaName;
    private String safetyRule;
}
