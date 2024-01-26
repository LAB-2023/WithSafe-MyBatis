package com.withsafe.domain.warning.domain;

import com.withsafe.domain.department.domain.Department;
import com.withsafe.domain.notice.domain.NoticeJpa;
import com.withsafe.domain.warning.dto.WarningMessageDto;
import com.withsafe.global.BaseTimeDomain;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
public class WarningMessage extends BaseTimeDomain {
    @Id @GeneratedValue
    @Column(name = "warning_message_id")
    private Long id;

    private String content; // 경고 메시지

    @Enumerated(EnumType.STRING)
    private WarningMessageType type; // 경고 메시지 타입
    // private LocalDateTime date; //경고 메시지 발생시간

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "warning_message")
    private List<NoticeJpa> noticeList;

    private Department department;

    @Builder
    public WarningMessage(Long id, String content, WarningMessageType type, List<NoticeJpa> noticeList, Department department) {
        this.id = id;
        this.content = content;
        this.type = type;
        this.noticeList = noticeList;
        this.department = department;
    }

    //수정
    public void update(WarningMessageDto.UpdateRequest updateRequest){
        this.content = updateRequest.getContent();
    }
}
