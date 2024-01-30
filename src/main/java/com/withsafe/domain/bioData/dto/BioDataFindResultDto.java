package com.withsafe.domain.bioData.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Getter
@NoArgsConstructor
public class BioDataFindResultDto {
    private List<Integer> heartRate = new ArrayList<>();
    private List<Double> temperature = new ArrayList<>();
    private List<Integer> walkCount = new ArrayList<>();
    private List<Double> oxygen = new ArrayList<>();
    private List<Integer> calorie = new ArrayList<>();
    private List<Boolean> isFall = new ArrayList<>();
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private List<LocalDateTime> createdDate;

    @Builder
    public BioDataFindResultDto(List<Integer> heartRate, List<Double> temperature, List<Integer> walkCount,
                                List<Double> oxygen, List<Integer> calorie, List<Boolean> isFall, List<LocalDateTime> createdDate) {
        this.heartRate = heartRate;
        this.temperature = temperature;
        this.walkCount = walkCount;
        this.oxygen = oxygen;
        this.calorie = calorie;
        this.isFall = isFall;
        this.createdDate = createdDate;
    }
}
