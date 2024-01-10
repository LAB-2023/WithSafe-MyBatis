package com.withsafe.domain.bioData.dto;

import com.withsafe.domain.BaseTimeEntity;
import com.withsafe.domain.bioData.domain.BioData;
import com.withsafe.domain.user.domain.User;
import lombok.*;

import java.time.LocalDateTime;

public class BioDataDto {
    //Watch5 / Watch6 용 심박수
    private Integer heartRate;
    //Watch6 피부온도
    private Double temperature;
    private Integer walkCount;
    private Double oxygen;
    private Integer calorie;
    private Boolean isFall;
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class SaveRequest{
        private Integer heartRate;
        private Double temperature;
        private Integer walkCount;
        private Double oxygen;
        private Integer calorie;
        private Boolean isFall;
        @Builder
        public SaveRequest(Integer heartRate, Double temperature, Integer walkCount, Double oxygen,
                           Integer calorie, Boolean isFall) {
            this.heartRate = heartRate;
            this.temperature = temperature;
            this.walkCount = walkCount;
            this.oxygen = oxygen;
            this.calorie = calorie;
            this.isFall = isFall;
        }
        public BioData toEntity(User user){
            return BioData.builder()
                    .heartRate(this.heartRate)
                    .temperature(this.temperature)
                    .walkCount(this.walkCount)
                    .oxygen(this.oxygen)
                    .calorie(this.calorie)
                    .isFall(this.isFall)
                    .user(user)
                    .build();
        }
    }

    @Getter @Setter
    @NoArgsConstructor
    public static class FindRequest{
        private Integer heartRate;
        private Double temperature;
        private Integer walkCount;
        private Double oxygen;
        private Integer calorie;
        private Boolean isFall;
        private LocalDateTime createdDate;
        @Builder
        public FindRequest(Integer heartRate, Double temperature, Integer walkCount,
                           Double oxygen, Integer calorie, Boolean isFall, LocalDateTime createdDate) {
            this.heartRate = heartRate;
            this.temperature = temperature;
            this.walkCount = walkCount;
            this.oxygen = oxygen;
            this.calorie = calorie;
            this.isFall = isFall;
            this.createdDate = createdDate;
        }
        public static BioData toEntity(BioData bioData){
            return BioData.builder()
                    .heartRate(bioData.getHeartRate())
                    .temperature(bioData.getTemperature())
                    .walkCount(bioData.getWalkCount())
                    .oxygen(bioData.getOxygen())
                    .calorie(bioData.getCalorie())
                    .isFall(bioData.getIsFall())
                    .build();
        }

        public static FindRequest toFindRequest(BioData bioData){
            return FindRequest.builder()
                    .heartRate(bioData.getHeartRate())
                    .temperature(bioData.getTemperature())
                    .walkCount(bioData.getWalkCount())
                    .oxygen(bioData.getOxygen())
                    .calorie(bioData.getCalorie())
                    .isFall(bioData.getIsFall())
                    .build();
        }
    }
}
