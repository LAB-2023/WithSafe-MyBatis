package com.withsafe.domain.notice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.withsafe.domain.notice.domain.NoticeJpa;
import com.withsafe.domain.warning.domain.WarningMessageType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class NoticeWarningResponseDto {
    private Long id;
    private String name;
    private WarningMessageType warningMessageType;
    private String noticeContent;
    private String solveContent;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime solveDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createdDate;

    @Builder
    public NoticeWarningResponseDto(Long id, String name, WarningMessageType warningMessageType, String noticeContent,
                                    String solveContent, LocalDateTime solveDate, LocalDateTime createdDate) {
        this.id = id;
        this.name = name;
        this.noticeContent = noticeContent;
        this.solveContent = solveContent;
        this.solveDate = solveDate;
        this.warningMessageType = warningMessageType;
        this.createdDate = createdDate;
    }

    public static NoticeWarningResponseDto toNoticeWaringResponse(NoticeJpa notice){
        return NoticeWarningResponseDto.builder()
                .id(notice.getId())
                .name(notice.getWatch().getUser().getName())
                .warningMessageType(notice.getWarning_message().getType())
                .noticeContent(notice.getContent())
                .solveContent(notice.getSolve().getContent())
                .solveDate(notice.getSolve().getCreatedDate())
                .createdDate(notice.getCreatedDate())
                .build();
    }
}
