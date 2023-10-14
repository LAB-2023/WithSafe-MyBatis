package com.withsafe.domain.indoorEntrance.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class SearchResultDto {
    private int deviceNum; //디바이스번호(PK와 다름)
    private String userName;
    private String mapName;
    private LocalDateTime enterTime;
    private LocalDateTime exitTime;

    @Builder
    public SearchResultDto(int deviceNum, String userName, String mapName, LocalDateTime enterTime, LocalDateTime exitTime) {
        this.deviceNum = deviceNum;
        this.userName = userName;
        this.mapName = mapName;
        this.enterTime = enterTime;
        this.exitTime = exitTime;
    }
}
