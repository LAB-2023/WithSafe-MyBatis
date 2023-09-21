package com.withsafe.domain.area;

import com.withsafe.domain.device.Watch;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.awt.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class OutdoorUserLocation {
    @Id @GeneratedValue
    @Column(name = "outdoor_user_location_id")
    private Long id;

    private Point coordinate;

    private LocalDateTime date;

    //연관관계 매핑
    @ManyToOne
    private Watch watch;
}
