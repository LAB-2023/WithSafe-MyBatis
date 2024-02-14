package com.withsafe.domain.watch.dto;

import com.withsafe.domain.watch.domain.Watch;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class WatchFindDto {
    private String serialNum;
    private String model;
    private Boolean is_used;
    private Integer deviceNum;
    private String username;
    private Long watchId;
    @Builder
    public WatchFindDto(String serialNum, String model, Boolean is_used, Integer deviceNum, String username, Long watchId) {
        this.serialNum = serialNum;
        this.model = model;
        this.is_used = is_used;
        this.deviceNum = deviceNum;
        this.username = username;
        this.watchId = watchId;
    }
    public static Watch toEntity(Watch watch){
        return Watch.builder()
                .serialNum(watch.getSerialNum())
                .model(watch.getModel())
                .is_used(watch.getIs_used())
                .deviceNum(watch.getDeviceNum())
                .build();
    }

    public static WatchFindDto toFindRequest(Watch watch, String username){
        return WatchFindDto.builder().
                deviceNum(watch.getDeviceNum())
                .model(watch.getModel())
                .is_used(watch.getIs_used())
                .serialNum(watch.getSerialNum())
                .username(username)
                .watchId(watch.getId())
                .build();
    }
}
