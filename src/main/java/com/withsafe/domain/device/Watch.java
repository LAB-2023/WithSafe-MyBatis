package com.withsafe.domain.device;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Watch {
    @Id @GeneratedValue
    @Column(name = "watch_id")
    private Long id;

    //FK
    private Long user;

    private String serial_num;
    private LocalDateTime operating_date;

    private String model;

    private Boolean is_used;

    private int device_num;
}
