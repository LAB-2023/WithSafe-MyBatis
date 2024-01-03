package com.withsafe.domain.watch.dto;

import com.withsafe.domain.watch.domain.Watch;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StartRequestDto {
    private Long watchId;
    private Long userId;
    private String userName;
    private String departmentName;
    private Integer uploadInterval;

    @Builder
    public StartRequestDto(Long watchId, Long userId, String userName, String departmentName) {
        this.watchId = watchId;
        this.userId = userId;
        this.userName = userName;
        this.departmentName = departmentName;
        this.uploadInterval = 1; //1분
    }

    public static WatchDTO.StartRequest toStartRequest(Watch watch, String username) {
        return WatchDTO.StartRequest.builder()
                .watchId(watch.getId())
                .userId(watch.getUser().getId())
                .userName(username)
                .departmentName(watch.getDepartment().getName())
                .uploadInterval(1)
                .build();
    }
}
