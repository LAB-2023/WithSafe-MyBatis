package com.withsafe.domain.watch.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class SearchCondition {

    private String serialNum;
    private String departmentName;
    private String username;

    @Builder
    public SearchCondition(String serialNum, String departmentName, String username) {
        this.serialNum = serialNum;
        this.departmentName = departmentName;
        this.username = username;
    }

    public static SearchCondition toSearchCondition(String serialNum, String departmentName, String username) {
        return SearchCondition.builder()
                .serialNum(serialNum).departmentName(departmentName).username(username)
                .build();
    }
}
