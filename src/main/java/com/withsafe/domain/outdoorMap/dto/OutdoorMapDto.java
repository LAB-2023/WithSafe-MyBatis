package com.withsafe.domain.outdoorMap.dto;

import lombok.Builder;
import lombok.Getter;

public class OutdoorMapDto {

    @Builder
    @Getter
    public static class SaveRequestDto {
        private String mapName;
        private Double coordinate_x;
        private Double coordinate_y;
    }
}
