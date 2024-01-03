package com.withsafe.domain.watchData.dto;

import com.withsafe.domain.watch.domain.Watch;
import com.withsafe.domain.watchData.domain.WatchData;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class WatchDataDTO {
    @Getter
    @NoArgsConstructor
    public static class SaveRequest {
        private String battery; //워치 배터리 잔량
        private String charge;  //워치의 충전 상태 (방전, 충전중, 충전완료)

        @Builder
        public SaveRequest(String battery, String charge) {
            this.battery = battery;
            this.charge = charge;
        }
        public WatchData toEntity(Watch watch) {
            return WatchData.builder()
                    .battery(battery)
                    .charge(charge)
                    .watch(watch)
                    .build();
        }
    }
    @Getter
    @NoArgsConstructor
    public static class FindRequest {
        private String battery;
        private String charge;
        private Long watchId;
        @Builder
        public FindRequest(String battery, String charge, Long watchId) {
            this.battery = battery;
            this.charge = charge;
            this.watchId = watchId;
        }
        public static FindRequest toFindRequest(WatchData watchData){
            return FindRequest.builder()
                    .battery(watchData.getBattery())
                    .charge(watchData.getCharge())
                    .watchId(watchData.getWatch().getId())
                    .build();
        }
    }
}