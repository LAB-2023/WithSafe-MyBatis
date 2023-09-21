package com.withsafe.domain.device;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class helmet {
    @Id @GeneratedValue
    private Long id;

    private String serial_num;
    private LocalDateTime operating_date;

    private String model;

    private Boolean is_used;

    private int device_num;
}
