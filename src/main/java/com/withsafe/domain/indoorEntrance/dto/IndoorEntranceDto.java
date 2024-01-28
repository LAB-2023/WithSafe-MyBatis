package com.withsafe.domain.indoorEntrance.dto;

import com.withsafe.domain.beacon.domain.BeaconJpa;
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

    private static class IndoorEntranceInfo{
        private Long id;
        private LocalDateTime createdDate;

        private LocalDateTime modifiedDate;

        private BeaconJpa beacon;  //실내 구역 출입을 인지한 비콘의 id

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

    //검색 결과 저장
//    @Builder
//    @Getter
//    public static class SearchResult{
//        private int deviceNum; //디바이스번호(PK와 다름)
//        private String userName;
//        private String mapName;
//        private LocalDateTime enterTime;
//        private LocalDateTime exitTime;
//
//
//    }
}
