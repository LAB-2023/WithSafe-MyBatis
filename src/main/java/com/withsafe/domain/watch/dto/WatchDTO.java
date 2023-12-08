package com.withsafe.domain.watch.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.withsafe.domain.department.domain.Department;
import com.withsafe.domain.deviceSetting.dto.DeviceSettingDTO;
import com.withsafe.domain.deviceSetting.dto.DeviceSettingDTO.FindDeviceSettingRequestDTO;
import com.withsafe.domain.user.domain.Sex;
import com.withsafe.domain.user.domain.User;
import com.withsafe.domain.watch.domain.Watch;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.NotBlank;

public class WatchDTO {
    private String serialNum; //Watch 시리얼 번호
    private String model; //Watch 모델명
    private Boolean is_used; //Watch 사용유무
    private Integer deviceNum; //Watch 디바이스 번호
    private LocalDateTime regDate; //Watch 등록일
    private Long userId; //Watch에 매핑될 User id
    private Department department; //Watch에 매핑될 Department
    //Watch 저장시 사용
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class SaveRequest{

        @NotBlank(message = "시리얼 번호를 입력해주세요.")
        private String serialNum; //Watch 시리얼 번호
        @NotBlank(message = "모델명을 입력해주세요.")
        private String model; //Watch 모델명
        private Boolean is_used; //Watch 사용유무
        @NotBlank(message = "디바이스 번호를 입력해주세요.")
        private Integer deviceNum; //Watch 디바이스 번호
        @NotBlank(message = "디바이스 등록일을 입력해주세요.")
        @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        private LocalDateTime regDate; //Watch 등록일
        private Long userId; //Watch 에 매핑된 User id

        @Builder
        public SaveRequest(String serialNum, String model, Boolean is_used, Integer deviceNum, LocalDateTime regDate) {
            this.serialNum = serialNum;
            this.model = model;
            this.is_used = false;
            this.deviceNum = deviceNum;
            this.regDate = regDate;
        }
        public Watch toEntity(Department department){
            return Watch.builder()
                    .serialNum(this.serialNum)
                    .model(this.model)
                    .is_used(false)
                    .deviceNum(this.deviceNum)
                    .department(department)
                    .build();
        }
    }

    //Watch List 조회시 사용
    @Getter @Setter
    @NoArgsConstructor
    public static class FindRequest {
        private String serialNum;
        private String model;
        private Boolean is_used;
        private Integer deviceNum;
        private String userName;
        private Long watchId;
        @Builder
        public FindRequest(String serialNum, String model, Boolean is_used, Integer deviceNum, String userName, Long watchId) {
            this.serialNum = serialNum;
            this.model = model;
            this.is_used = is_used;
            this.deviceNum = deviceNum;
            this.userName = userName;
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
        public static FindRequest toFindRequest(Watch watch, String username){
            return FindRequest.builder().
                    deviceNum(watch.getDeviceNum())
                    .model(watch.getModel())
                    .is_used(watch.getIs_used())
                    .serialNum(watch.getSerialNum())
                    .userName(username)
                    .watchId(watch.getId())
                    .build();
        }
    }
    @Getter @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class StartRequest{
        private Long watchId;
        private Long userId;
        private String userName;
        private String departmentName;
        private Integer uploadInterval;

        @Builder
        public StartRequest(Long watchId, Long userId, String userName, String departmentName, Integer uploadInterval) {
            this.watchId = watchId;
            this.userId = userId;
            this.userName = userName;
            this.departmentName = departmentName;
            this.uploadInterval = 1; //1분
        }

        public static StartRequest toStartRequest(Watch watch, String username) {
            return StartRequest.builder()
                    .watchId(watch.getId())
                    .userId(watch.getUser().getId())
                    .userName(username)
                    .departmentName(watch.getDepartment().getName())
                    .uploadInterval(1)
                    .build();
        }
    }
}