package com.withsafe.domain;


import com.withsafe.domain.area.IndoorMap;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "indoor_map_id")
    private IndoorMap indoorMap;
}
