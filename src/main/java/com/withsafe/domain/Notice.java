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

    private String type;
    private String content;
    private LocalDateTime date;

    //FK
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warning_message_id")
    private WarningMessage warning_message;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "watch_id")
    private Watch watch;

    @OneToOne(mappedBy = "notice", fetch = FetchType.LAZY)
    private Solve solve;
}
