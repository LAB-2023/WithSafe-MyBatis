package com.withsafe.domain.notice.dto;

import com.withsafe.domain.notice.domain.Notice;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NoticeEmergencyContactDto {
    private String department;
    private String name;
    private String phoneNumber;

    @Builder
    public NoticeEmergencyContactDto(String department, String name, String phoneNumber) {
        this.department = department;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public static NoticeEmergencyContactDto toNoticeEmergencyContactDto(String department, String name, String phoneNumber){
        return NoticeEmergencyContactDto.builder()
                .department(department)
                .name(name)
                .phoneNumber(phoneNumber)
                .build();
    }
}