package com.withsafe.domain.area;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.awt.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class RestrictArea {
    @Id
    private Long id;

    private String name;

    private String safetyRule;

    private Point coordinate;

    //연관관계 매핑
    @ManyToOne
    private IndoorMap indoorMap;
    @ManyToOne
    private OutdoorMap outdoorMap;
}
