package com.withsafe.domain.watch.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.withsafe.domain.user.domain.User;
import com.withsafe.domain.watch.domain.Watch;
import lombok.*;
import javax.validation.constraints.NotBlank;

public class WatchDTO {
    private String serialNum; //Watch 시리얼 번호
    private String model; //Watch 모델명
    private Boolean is_used; //Watch 사용유무
    private Integer deviceNum; //Watch 디바이스 번호
    private LocalDateTime regDate; //Watch 등록일
    private Long userId; //Watch에 매핑된 User id

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
        private LocalDateTime regDate; //Watch 등록일
        private Long userId; //Watch 에 매핑된 User id

        @Builder
        public SaveRequest(String serialNum, String model, Boolean is_used, Integer deviceNum, Long userId, LocalDateTime regDate) {
            this.serialNum = serialNum;
            this.model = model;
            this.is_used = is_used;
            this.deviceNum = deviceNum;
            this.userId = userId;
            this.regDate = regDate;
        }

        public Watch toEntity(User user){
            return Watch.builder()
//                    .user(User.builder().userName(userName).build()) //user builder 생성시 사용
                    .serialNum(this.serialNum)
                    .model(this.model)
                    .is_used(this.is_used)
                    .deviceNum(this.deviceNum)
                    .regDate(this.regDate)
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
        public FindRequest(Watch watch) {
            this.serialNum = watch.getSerialNum();
            this.model = watch.getModel();
            this.is_used = watch.getIs_used();
            this.deviceNum = watch.getDeviceNum();
            this.userName = (watch.getUser()).getName();
            this.watchId = watch.getId();
        }

        public Watch toEntity(Watch watch){
            return Watch.builder()
                    .serialNum(watch.getSerialNum())
                    .model(watch.getModel())
                    .is_used(watch.getIs_used())
                    .deviceNum(watch.getDeviceNum())
                    .build();
        }
    }

    @Getter @Setter
    @NoArgsConstructor
    public static class DeleteRequest{
        private Long watchId;
        @Builder
        public DeleteRequest(Long watchId){
            this.watchId = watchId;
        }
    }

}
