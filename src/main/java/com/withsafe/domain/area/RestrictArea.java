package com.withsafe.domain.area;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.awt.*;

@Entity
@Getter
@RequiredArgsConstructor
public class RestrictArea {
    @Id @GeneratedValue
    @Column(name = "restrict_area_id")
    private Long id;

    private String name;

    private String safetyRule;

    private Point coordinate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "indoor_map_id")
    private IndoorMap indoorMap;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "outdoor_map_id")
    private OutdoorMap outdoorMap;

    // == 연관관계 편의 메서드 == //
    public void setIndoorMap(IndoorMap indoorMap) {
        this.indoorMap = indoorMap;
        indoorMap.getRestrictAreaList().add(this);
    }

    public void setOutdoorMap(OutdoorMap outdoorMap) {
        this.outdoorMap = outdoorMap;
        outdoorMap.getRestrictAreaList().add(this);
    }
}
