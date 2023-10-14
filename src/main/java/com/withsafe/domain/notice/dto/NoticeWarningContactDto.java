package com.withsafe.domain.notice.dto;

import com.withsafe.domain.notice.domain.Notice;
import com.withsafe.domain.notice.domain.NoticeType;
import com.withsafe.domain.warning.domain.WarningMessage;
import com.withsafe.domain.watch.domain.Watch;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@NoArgsConstructor
public class NoticeWarningContactDto {
    private String department;
    private String name;
    private String phoneNumber;

    @Builder
    public NoticeWarningContactDto(String department, String name, String phoneNumber) {
        this.department = department;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}