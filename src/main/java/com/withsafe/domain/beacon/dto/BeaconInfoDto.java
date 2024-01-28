package com.withsafe.domain.beacon.dto;

import com.withsafe.domain.beacon.domain.BeaconType;
import com.withsafe.domain.indoorEntrance.dto.IndoorEntranceInfoDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;

import javax.persistence.Column;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BeaconInfoDto {
    private Long beaconId;
    private BeaconType beaconType;
    private Double coordinate_x;
    private Double coordinate_y;
//    @Column(columnDefinition = "geometry(Point, 4326)")
//    private Point beaconCoordinate;
    private List<IndoorEntranceInfoDto> indoorEntranceInfoDtoList;
}
