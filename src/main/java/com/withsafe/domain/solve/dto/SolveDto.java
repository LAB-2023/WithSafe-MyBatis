package com.withsafe.domain.solve.dto;

import com.withsafe.domain.notice.domain.Notice;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class SolveDto {

    @Getter
    @NoArgsConstructor
    public static class SaveRequest{
        private String content;
        private Long noticeId;

        public SaveRequest(String content, Long noticeId) {
            this.content = content;
            this.noticeId = noticeId;
        }
    }

    //조치 사항이 존재하는지
    @Getter
    @NoArgsConstructor
    public static class FindRequest{
        private Long noticeId;

        public FindRequest(Long noticeId) {
            this.noticeId = noticeId;
        }
    }

    @Getter
    @NoArgsConstructor
    public static class SolveResponse{
        private String content;
        private LocalDateTime createdDate;
        public SolveResponse(String content, LocalDateTime createdDate) {
            this.content = content;
            this.createdDate = createdDate;
        }
    }
}
