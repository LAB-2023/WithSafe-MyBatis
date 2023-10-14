package com.withsafe.domain.notice.dto;

import com.withsafe.domain.notice.domain.Notice;
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
    private String solveContent;
    private LocalDateTime solveDate;
    private LocalDateTime createdDate;

    @Builder
    public NoticeWarningResponseDto(Long id, String name, WarningMessageType warningMessageType, String solveContent, LocalDateTime solveDate, LocalDateTime createdDate) {
        this.id = id;
        this.name = name;
        this.solveContent = solveContent;
        this.solveDate = solveDate;
        this.warningMessageType = warningMessageType;
        this.createdDate = createdDate;
    }

    public static NoticeWarningResponseDto toNoticeWaringResponse(Notice notice){
        return NoticeWarningResponseDto.builder()
                .id(notice.getId())
                .name(notice.getWatch().getUser().getName())
                .warningMessageType(notice.getWarning_message().getType())
                .solveContent(notice.getSolve().getContent())
                .solveDate(notice.getSolve().getCreatedDate())
                .createdDate(notice.getCreatedDate())
                .build();
    }
}
