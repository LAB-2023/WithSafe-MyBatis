package com.withsafe.domain.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class BioData {
    @Id @GeneratedValue
    private Long id;

    private int heart_rate;
    private double temperature;
    private LocalDateTime reg_dt;
    private int walk_count;
    private double oxygen;
}
