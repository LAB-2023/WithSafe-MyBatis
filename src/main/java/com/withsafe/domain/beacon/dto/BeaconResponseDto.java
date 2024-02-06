package com.withsafe.domain.beacon.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.withsafe.domain.beacon.domain.BeaconType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class BeaconResponseDto {
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createdDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime modifiedDate;
    private BeaconType beaconType;
    private Double coordinate_x;
    private Double coordinate_y;
    private String macAddress;
    private String status;
    private String indoorMapName;

    @Builder
    public BeaconResponseDto(Long id, LocalDateTime createdDate, LocalDateTime modifiedDate, BeaconType beaconType,
                       Double coordinate_x, Double coordinate_y, String macAddress, String status, String indoorMapName) {
        this.id = id;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.beaconType = beaconType;
        this.coordinate_x = coordinate_x;
        this.coordinate_y = coordinate_y;
        this.macAddress = macAddress;
        this.status = status;
        this.indoorMapName = indoorMapName;
    }
}