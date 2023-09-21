package com.withsafe.domain.data;

import com.withsafe.domain.device.Watch;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class BioData {
    @Id @GeneratedValue
    @Column(name = "bio_data_id")
    private Long id;

    private int heartRate;
    private double temperature;
    private LocalDateTime date;
    private int walkCount;
    private double oxygen;

    //연관관계 매핑
    @ManyToOne
    private Watch watch;
}
