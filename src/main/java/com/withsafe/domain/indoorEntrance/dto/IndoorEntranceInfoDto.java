package com.withsafe.domain.indoorEntrance.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IndoorEntranceInfoDto {
    private Long watchId;
    private String modifiedDate;
    private String username;
}
