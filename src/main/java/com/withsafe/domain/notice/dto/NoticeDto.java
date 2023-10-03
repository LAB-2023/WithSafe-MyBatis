package com.withsafe.domain.notice.dto;

import com.withsafe.domain.department.domain.Department;
import com.withsafe.domain.notice.domain.NoticeType;
import com.withsafe.domain.solve.dto.SolveDto;
import com.withsafe.domain.warning.domain.WarningMessage;
import com.withsafe.domain.warning.domain.WarningMessageType;
import com.withsafe.domain.watch.domain.Watch;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

public class NoticeDto {

    @Getter
    @NoArgsConstructor
    public static class SaveRequest //워치에서 어떻게 쏴줄지 모르겠음
    {
        private String content;
        @Enumerated(EnumType.STRING)
        private NoticeType type;
        private Long warningMessageId;
        private Long watchId;

        public SaveRequest(String content, NoticeType type, Long warningMessageId, Long watchId) {
            this.content = content;
            this.type = type;
            this.warningMessageId = warningMessageId;
            this.watchId = watchId;
        }
    }

    @Getter
    @NoArgsConstructor
    public static class NoticeResponse{
        private Long id;
        private String departmentName;
        private String username;
        private WarningMessageType type;
        private SolveDto.SolveResponse solveResponse;
        private LocalDateTime date;

        public NoticeResponse(Long id, String departmentName, String username, WarningMessageType type, SolveDto.SolveResponse solveResponse, LocalDateTime date) {
            this.id = id;
            this.departmentName = departmentName;
            this.username = username;
            this.type = type;
            this.solveResponse = solveResponse;
            this.date = date;
        }

        public NoticeResponse(Long id, String username, WarningMessageType type, SolveDto.SolveResponse solveResponse, LocalDateTime date) {
            this.id = id;
            this.username = username;
            this.type = type;
            this.solveResponse = solveResponse;
            this.date = date;
        }
    }
}
