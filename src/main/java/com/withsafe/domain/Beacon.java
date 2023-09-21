package com.withsafe.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.awt.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Beacon {

    @Id @GeneratedValue
    @Column(name = "beacon_id")
    private Long id;

    private Point coordinate;
    private LocalDateTime date;
    private String status;
    //FK
    private Long indoorMap;
}
