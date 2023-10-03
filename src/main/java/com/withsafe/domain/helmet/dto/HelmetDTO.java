package com.withsafe.domain.helmet.dto;

import com.withsafe.domain.helmet.domain.Helmet;
import com.withsafe.domain.user.domain.User;
import com.withsafe.domain.watch.dto.WatchDTO;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

public class HelmetDTO {
    private String serialNum;   //시리얼번호
    private String model;   //모델 정보
    private Boolean is_used;    //사용유무
    private Long deviceNum; //디바이스번호 (PK와 다름)
    private Long watchId;

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class SaveRequest {
        @NotBlank(message = "시리얼 번호를 입력해주세요.")
        private String serialNum;
        @NotBlank(message = "모델명을 입력해주세요.")
        private String model;
        private Boolean is_used;
        @NotBlank(message = "디바이스 번호를 입력해주세요.")
        private Long deviceNum;
        private Long watchId;

        @Builder
        public SaveRequest(String serialNum, String model, Boolean is_used, Long deviceNum, Long watchId) {
            this.serialNum = serialNum;
            this.model = model;
            this.is_used = is_used;
            this.deviceNum = deviceNum;
            this.watchId = watchId;
        }

        /**
         * Helmet Entity로 변환
         * @param user
         * @return Helmet
         * TODO : watchId를 받아서 watchId로 watch를 찾아서 넣어줘야함
         */
        public Helmet toEntity(User user) {
            return Helmet.builder()
                    .serialNum(serialNum)
                    .model(model)
                    .is_used(is_used)
                    .deviceNum(deviceNum)
                    .build();
        }
    }
}
