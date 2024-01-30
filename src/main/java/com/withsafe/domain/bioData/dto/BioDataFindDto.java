package com.withsafe.domain.bioData.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.withsafe.domain.bioData.domain.BioData;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class BioDataFindDto{
    private Integer heartRate;
    private Double temperature;
    private Integer walkCount;
    private Double oxygen;
    private Integer calorie;
    private Boolean isFall;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createdDate;
    @Builder
    public BioDataFindDto(Integer heartRate, Double temperature, Integer walkCount,
                       Double oxygen, Integer calorie, Boolean isFall, LocalDateTime createdDate) {
        this.heartRate = heartRate;
        this.temperature = temperature;
        this.walkCount = walkCount;
        this.oxygen = oxygen;
        this.calorie = calorie;
        this.isFall = isFall;
        this.createdDate = createdDate;
    }
    public static BioData toEntity(BioData bioData) {
        return BioData.builder()
                .heartRate(bioData.getHeartRate())
                .temperature(bioData.getTemperature())
                .walkCount(bioData.getWalkCount())
                .oxygen(bioData.getOxygen())
                .calorie(bioData.getCalorie())
                .isFall(bioData.getIsFall())
                .build();
    }
}