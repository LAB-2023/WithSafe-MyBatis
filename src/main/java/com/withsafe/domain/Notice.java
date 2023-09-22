package com.withsafe.domain;

import com.withsafe.domain.device.Watch;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Notice {

    @Id @GeneratedValue
    @Column(name = "notice_id")
    private Long id;

    private String type;    //경고 알림 타입
    private String content; //내용
    private LocalDateTime date; //알림 발생 시각

    //FK
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warning_message_id")
    private WarningMessage warning_message; //알림에 따른 경고 메시지 id

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "watch_id")
    private Watch watch;    //경고 알림을 발생시킨 워치 id

        @OneToOne(mappedBy = "notice", fetch = FetchType.LAZY)
        private Solve solve;    //경고 알림에 대한 조치
}
