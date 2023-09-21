package com.withsafe.domain;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Solve {

    @Id @GeneratedValue
    private Long id;

    private String content;
    private LocalDateTime date;

    //FK
    private Long notice;
}
