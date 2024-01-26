package com.withsafe.domain.solve.domain;

import com.withsafe.domain.BaseTimeEntity;
import com.withsafe.domain.notice.domain.Notice;
import com.withsafe.domain.solve.dto.SolveDto;
import com.withsafe.global.BaseTimeDomain;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Getter
@RequiredArgsConstructor
public class Solve extends BaseTimeDomain {


    private Long id;
    private String content; //조치 내용
    private Notice notice;  //조치된 경고알림 id

    @Builder
    public Solve(Long id, String content, Notice notice) {
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
