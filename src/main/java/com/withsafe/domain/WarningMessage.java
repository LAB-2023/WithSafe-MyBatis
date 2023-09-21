package com.withsafe.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class WarningMessage {
    @Id @GeneratedValue
    private Long id;

//    @Lob
    private String content; // 경고 메시지
    private String type; // 경고 메시지 발생 시간
    private LocalDateTime date;

}
