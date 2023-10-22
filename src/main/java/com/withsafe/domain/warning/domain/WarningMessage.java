package com.withsafe.domain.warning.domain;

import com.withsafe.domain.BaseTimeEntity;
import com.withsafe.domain.notice.domain.Notice;
import com.withsafe.domain.warning.dto.WarningMessageDto;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@RequiredArgsConstructor
@Getter
public class WarningMessage extends BaseTimeEntity {
    @Id @GeneratedValue
    @Column(name = "warning_message_id")
    private Long id;

//    @Lob
    private String content; // 경고 메시지

    @Enumerated(EnumType.STRING)
    private WarningMessageType type; // 경고 메시지 타입
    // private LocalDateTime date; //경고 메시지 발생시간

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "warning_message")
    private List<Notice> noticeList;

    @Builder
    public WarningMessage(Long id, String content, WarningMessageType type) {
        this.id = id;
        this.content = content;
        this.type = type;
    }

    //수정
    public void update(WarningMessageDto.UpdateRequest updateRequest){
        this.content = updateRequest.getContent();
    }
}
