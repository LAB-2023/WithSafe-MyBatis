package com.withsafe.domain.notice.domain;

import com.withsafe.domain.solve.domain.Solve;
import com.withsafe.domain.warning.domain.WarningMessage;
import com.withsafe.domain.watch.domain.Watch;
import com.withsafe.global.BaseTimeDomain;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Getter
@RequiredArgsConstructor
public class Notice extends BaseTimeDomain {

    @Id @GeneratedValue
    @Column(name = "notice_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private NoticeType noticeType; //알림 타입
    private String content; //내용

    //FK
    private WarningMessage warning_message; //알림에 따른 경고 메시지 id
    private Watch watch;    //경고 알림을 발생시킨 워치 id
    private Solve solve;    //경고 알림에 대한 조치

    @Builder
    public Notice(Long id, NoticeType noticeType, String content,
                     WarningMessage warning_message, Watch watch, Solve solve) {
        this.id = id;
        this.noticeType = noticeType;
        this.content = content;
        this.warning_message = warning_message;
        this.watch = watch;
        this.solve = solve;
    }
}
