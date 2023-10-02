package com.withsafe.domain.warning.dto;

import com.withsafe.domain.solve.dto.SolveDto;
import com.withsafe.domain.warning.domain.WarningMessage;
import com.withsafe.domain.warning.domain.WarningMessageType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

public class WarningMessageDto {

    @Getter
    @NoArgsConstructor
    public static class SaveRequest{

        private String content;

        @Enumerated(EnumType.STRING)
        private WarningMessageType type;

        @Builder
        public SaveRequest(String content, WarningMessageType type) {
            this.type = type;
            this.content = content;
        }
    }

    @Getter
    @NoArgsConstructor
    public static class UpdateRequestList{
        private List<WarningMessageDto.UpdateRequest> products;
    }

    @Getter
    @NoArgsConstructor
    public static class UpdateRequest{
        private Long id;
        private String content;

        @Builder
        public UpdateRequest(Long id, String content) {
            this.id = id;
            this.content = content;
        }
    }

    @Getter
    @NoArgsConstructor
    public static class WarningMessageResponse{
        private Long id;
        private String content;
        @Enumerated(EnumType.STRING)
        private WarningMessageType type;

        public WarningMessageResponse(Long id, String content, WarningMessageType type) {
            this.id = id;
            this.content = content;
            this.type = type;
        }
    }
}
