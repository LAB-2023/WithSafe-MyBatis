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
public class NoticeSaveRequestDto //워치에서 어떻게 쏴줄지 모르겠음
{
    private String content;
    @Enumerated(EnumType.STRING)
    private NoticeType type;
    private Long warningMessageId;
    private Long watchId;

    @Builder
    public NoticeSaveRequestDto(String content, NoticeType type, Long warningMessageId, Long watchId) {
        this.content = content;
        this.type = type;
        this.warningMessageId = warningMessageId;
        this.watchId = watchId;
    }

    public Notice toEntity(WarningMessage warningMessage, Watch watch){
        return Notice.builder()
                .content(this.content)
                .noticeType(this.getType())
                .warning_message(warningMessage)
                .watch(watch)
                .build();
    }
}