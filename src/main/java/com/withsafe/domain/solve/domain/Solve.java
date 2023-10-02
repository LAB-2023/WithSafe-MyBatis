package com.withsafe.domain.solve.domain;

import com.withsafe.domain.BaseTimeEntity;
import com.withsafe.domain.notice.Notice;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@RequiredArgsConstructor
public class Solve extends BaseTimeEntity {

    @Id @GeneratedValue
    @Column(name = "solve_id")
    private Long id;

    private String content; //조치 내용
    private LocalDateTime date; //조치 시간

    //FK
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notice_id")
    private Notice notice;  //조치된 경고알림 id
}
