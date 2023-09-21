package com.withsafe.domain.area;

import com.withsafe.domain.UwbTag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.awt.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@RequiredArgsConstructor
public class IndoorUserLocation {
    @Id
    private Long id;

    private LocalDateTime date;

    private Point coordinate;

    private String mapId;

    //연관관계 매핑
    @ManyToOne
    private UwbTag uwbTag;
}
