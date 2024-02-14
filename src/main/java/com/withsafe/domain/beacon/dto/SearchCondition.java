package com.withsafe.domain.beacon.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SearchCondition {
    private String departmentName;
    private String macAddress;
    private String indoorMapName;

    public static SearchCondition toSearchCondition(String departmentName, String macAddress, String indoorMapName) {
        return SearchCondition.builder()
                .departmentName(departmentName)
                .macAddress(macAddress)
                .indoorMapName(indoorMapName)
                .build();
    }
}
