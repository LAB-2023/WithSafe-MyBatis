package com.withsafe.domain.notice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NoticeEmergencyContactDto {
    private String departmentName;
    private String name;
    private String phoneNumber;

    @Builder
    public NoticeEmergencyContactDto(String departmentName, String name, String phoneNumber) {
        this.departmentName = departmentName;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public static NoticeEmergencyContactDto toNoticeEmergencyContactDto(String departmentName, String name, String phoneNumber){
        return NoticeEmergencyContactDto.builder()
                .departmentName(departmentName)
                .name(name)
                .phoneNumber(phoneNumber)
                .build();
    }
}