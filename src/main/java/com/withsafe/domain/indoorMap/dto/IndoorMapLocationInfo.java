package com.withsafe.domain.indoorMap.dto;

import com.withsafe.domain.beacon.dto.BeaconInfoDto;
import com.withsafe.domain.indoorEntrance.dto.IndoorEntranceInfoDto;
import com.withsafe.domain.restrictArea.dto.RestrictAreaDto;
import com.withsafe.domain.restrictArea.dto.RestrictInfoDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

//특정 실내 지도에 대한 디테일한 정보
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IndoorMapLocationInfo{
    private Long indoorMapId;
    private String departmentName;
    private List<RestrictInfoDto> restrictInfoDtoList;
    private List<BeaconInfoDto> beaconInfoDtoList;

}
