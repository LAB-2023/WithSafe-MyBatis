package com.withsafe.domain.device;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Helmet {
    @Id @GeneratedValue
    private Long id;

    private String serialNum;
    private LocalDateTime openingDate;
    private String model;
    private Boolean is_used;
    private Long deviceNum;

    //FK
    private Long watch;
}
