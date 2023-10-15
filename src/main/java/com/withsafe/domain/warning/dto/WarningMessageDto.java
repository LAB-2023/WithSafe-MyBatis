package com.withsafe.domain.warning.dto;

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
        public WarningMessage toEntity(){
            return WarningMessage.builder()
                    .content(this.content)
                    .type(this.type)
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor
    public static class UpdateRequestList{
        private List<UpdateRequest> products;
    }

    @Getter
    @NoArgsConstructor
    public static class UpdateRequest{
        private String content;
        private WarningMessageType type;

        @Builder
        public UpdateRequest(String content, WarningMessageType type) {
            this.content = content;
            this.type = type;
        }
    }

    @Getter
    @NoArgsConstructor
    public static class WarningMessageResponse{
        private Long id;
        private String content;
        @Enumerated(EnumType.STRING)
        private WarningMessageType type;

        @Builder
        public WarningMessageResponse(Long id, String content, WarningMessageType type) {
            this.id = id;
            this.content = content;
            this.type = type;
        }

        //warning message to warningMessageDto
        public static WarningMessageResponse toWarningMessageResponse(WarningMessage warningMessage){
            return WarningMessageResponse.builder()
                    .id(warningMessage.getId())
                    .content(warningMessage.getContent())
                    .type(warningMessage.getType())
                    .build();
        }
    }
}
