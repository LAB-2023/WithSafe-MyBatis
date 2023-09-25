package com.withsafe.domain.notice;

import com.withsafe.domain.BaseTimeEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
public class WarningMessage extends BaseTimeEntity {
    @Id @GeneratedValue
    @Column(name = "warning_message_id")
    private Long id;

//    @Lob
    private String content; // 경고 메시지
    private String type; // 경고 메시지 타입
    // private LocalDateTime date; //경고 메시지 발생시간

}
