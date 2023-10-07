package com.withsafe.domain.notice.dto;

import com.withsafe.domain.notice.domain.Notice;
import com.withsafe.domain.notice.domain.NoticeType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class NoticeMainResponseDto //부서 추가 필요
{
    private Long id;
    //private String departmentName;
    private String username;
    private NoticeType noticeType;
    private String solveContent;
    private LocalDateTime solveDate;
    private LocalDateTime createdDate;

    @Builder
    public NoticeMainResponseDto(Long id, String username, NoticeType noticeType, String solveContent, LocalDateTime solveDate, LocalDateTime createdDate) {
        this.id = id;
        //this.departmentName = departmentName;
        this.username = username;
        this.solveContent = solveContent;
        this.solveDate = solveDate;
        this.noticeType = noticeType;
        this.createdDate = createdDate;
    }

    public static NoticeMainResponseDto toNoticeMainResponse(Notice notice){
        return NoticeMainResponseDto.builder()
                .id(notice.getId())
                .username(notice.getWatch().getUser().getName())
                .noticeType(notice.getNoticeType())
                .solveContent(notice.getSolve().getContent())
                .solveDate(notice.getSolve().getCreatedDate())
                .createdDate(notice.getCreatedDate())
                .build();
    }
}
