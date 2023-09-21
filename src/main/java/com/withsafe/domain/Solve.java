package com.withsafe.domain;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Solve {

    @Id @GeneratedValue
    @Column(name = "solve_id")
    private Long id;

    private String content;
    private LocalDateTime date;

    //FK
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notice_id")
    private Notice notice;
}
