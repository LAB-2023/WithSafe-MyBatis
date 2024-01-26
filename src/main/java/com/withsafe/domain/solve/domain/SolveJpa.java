package com.withsafe.domain.solve.domain;

import com.withsafe.domain.BaseTimeEntity;
import com.withsafe.domain.notice.domain.NoticeJpa;
import com.withsafe.domain.solve.dto.SolveDto;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@RequiredArgsConstructor
public class SolveJpa extends BaseTimeEntity {

    @Id @GeneratedValue
    @Column(name = "solve_id")
    private Long id;

    private String content; //조치 내용
    //private LocalDateTime date; //조치 시간

    //FK
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notice_id")
    private NoticeJpa notice;  //조치된 경고알림 id

    @Builder
    public SolveJpa(Long id, String content, NoticeJpa notice) {
        this.id = id;
        this.content = content;
        this.notice = notice;
    }

    public SolveDto.SolveResponse toSolveResponse(){
        return SolveDto.SolveResponse.builder()
                .content(this.content)
                .createdDate(this.getCreatedDate())
                .build();
    }
}
