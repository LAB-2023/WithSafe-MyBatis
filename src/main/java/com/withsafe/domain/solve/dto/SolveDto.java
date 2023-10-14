package com.withsafe.domain.solve.dto;

import com.withsafe.domain.notice.domain.Notice;
import com.withsafe.domain.solve.domain.Solve;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class SolveDto {

    @Getter
    @NoArgsConstructor
    public static class SaveRequest{
        private String content;
        private Long noticeId;

        @Builder
        public SaveRequest(String content, Long noticeId) {
            this.content = content;
            this.noticeId = noticeId;
        }

        public Solve toEntity(Notice notice){
            return Solve.builder()
                    .content(this.getContent())
                    .notice(notice)
                    .build();
        }
    }

    //조치 사항 있는지 확인
    @Getter
    @NoArgsConstructor
    public static class SolveResponse{
        private String content;
        private LocalDateTime createdDate;

        @Builder
        public SolveResponse(String content, LocalDateTime createdDate) {
            this.content = content;
            this.createdDate = createdDate;
        }
    }
}
