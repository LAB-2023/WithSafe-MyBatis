package com.withsafe.domain.indoorEntrance.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class IndoorEntranceDto {

    @Getter
    @NoArgsConstructor
    public static class SaveRequest{
        private String beaconMacAddress;
        private String watchSerialNum;

        @Builder
        public SaveRequest(String beaconMacAddress, String watchSerialNum) {
            this.beaconMacAddress = beaconMacAddress;
            this.watchSerialNum = watchSerialNum;
        }

    }

    //사용자에게 받은 검색 조건 저장
    @Builder
    @Getter
    public static class SearchCondition{
        private String userName;
        private LocalDateTime startDate;
        private LocalDateTime endDate;

        public static SearchCondition toSearchCondition(String userName, LocalDateTime startDate, LocalDateTime endDate) {
            return SearchCondition.builder()
                    .userName(userName)
                    .startDate(startDate)
                    .endDate(endDate)
                    .build();
        }
    }
}
