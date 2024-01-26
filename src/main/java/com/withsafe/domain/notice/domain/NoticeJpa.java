package com.withsafe.domain.notice.domain;

import com.withsafe.domain.BaseTimeEntity;
import com.withsafe.domain.solve.domain.SolveJpa;
import com.withsafe.domain.warning.domain.WarningMessageJpa;
import com.withsafe.domain.watch.domain.WatchJpa;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@RequiredArgsConstructor
public class NoticeJpa extends BaseTimeEntity {

    @Id @GeneratedValue
    @Column(name = "notice_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private NoticeType noticeType; //알림 타입
    private String content; //내용

    //FK
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warning_message_id")
    private WarningMessageJpa warning_message; //알림에 따른 경고 메시지 id

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "watch_id")
    private WatchJpa watch;    //경고 알림을 발생시킨 워치 id

    @OneToOne(mappedBy = "notice", fetch = FetchType.LAZY)
    private SolveJpa solve;    //경고 알림에 대한 조치

    @Builder
    public NoticeJpa(Long id, NoticeType noticeType, String content,
                     WarningMessageJpa warning_message, WatchJpa watch, SolveJpa solve) {
        this.id = id;
        this.noticeType = noticeType;
        this.content = content;
        this.warning_message = warning_message;
        this.watch = watch;
        this.solve = solve;
    }
}
