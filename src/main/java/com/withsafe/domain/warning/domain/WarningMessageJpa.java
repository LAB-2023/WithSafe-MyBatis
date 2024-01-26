package com.withsafe.domain.warning.domain;

import com.withsafe.domain.department.domain.DepartmentJpa;
import com.withsafe.domain.notice.domain.NoticeJpa;
import com.withsafe.domain.warning.dto.WarningMessageDto;
import com.withsafe.global.BaseTimeDomain;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@RequiredArgsConstructor
@Getter
public class WarningMessageJpa extends BaseTimeDomain {
    @Id @GeneratedValue
    @Column(name = "warning_message_id")
    private Long id;

//    @Lob
    private String content; // 경고 메시지

    @Enumerated(EnumType.STRING)
    private WarningMessageType type; // 경고 메시지 타입
    // private LocalDateTime date; //경고 메시지 발생시간

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "warning_message")
    private List<NoticeJpa> noticeList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private DepartmentJpa departmentJpa;

    @Builder
    public WarningMessageJpa(Long id, String content, WarningMessageType type, List<NoticeJpa> noticeList, DepartmentJpa departmentJpa) {
        this.id = id;
        this.content = content;
        this.type = type;
        this.noticeList = noticeList;
        this.departmentJpa = departmentJpa;
    }

    //수정
    public void update(WarningMessageDto.UpdateRequest updateRequest){
        this.content = updateRequest.getContent();
    }
}
