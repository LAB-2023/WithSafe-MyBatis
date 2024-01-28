package com.withsafe.domain.outdoorMap.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OutdoorMapFindRequestDto {
    private Long id;
    private String mapName;
    private Double coordinate_x;
    private Double coordinate_y;
    private Long departmentId;

    @Builder
    public OutdoorMapFindRequestDto(Long id, String mapName, Double coordinate_x, Double coordinate_y, Long departmentId) {
        this.id = id;
        this.mapName = mapName;
        this.coordinate_x = coordinate_x;
        this.coordinate_y = coordinate_y;
        this.departmentId = departmentId;
    }
}
