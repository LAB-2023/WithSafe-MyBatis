package com.withsafe.domain.bioData.dto;

import com.withsafe.domain.bioData.domain.BioData;
import com.withsafe.domain.user.domain.User;
import lombok.*;

public class BioDataSaveDto {
    private Integer heartRate;
    private Double temperature;
    private Integer walkCount;
    private Double oxygen;
    private Integer calorie;
    private Boolean isFall;
    @Builder
    public BioDataSaveDto(Integer heartRate, Double temperature, Integer walkCount, Double oxygen,
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
