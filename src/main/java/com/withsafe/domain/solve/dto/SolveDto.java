package com.withsafe.domain.solve.dto;

import com.withsafe.domain.notice.domain.Notice;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class SolveDto {

    @Getter
    @NoArgsConstructor
    public static class SaveRequest{
        private String content;
        private Notice notice;

        public SaveRequest(String content, Notice notice) {
            this.content = content;
            this.notice = notice;
        }
    }
}
