package com.withsafe.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Notice {

    @Id @GeneratedValue
    @Column(name = "notice_id")
    private Long id;

    private String type;
    private String content;
    private LocalDateTime date;

    //FK
    private Long warning_message;
    private Long watch_id;
}
