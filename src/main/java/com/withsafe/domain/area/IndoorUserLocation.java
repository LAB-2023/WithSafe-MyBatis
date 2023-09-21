package com.withsafe.domain.area;

import com.withsafe.domain.UwbTag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.awt.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@RequiredArgsConstructor
public class IndoorUserLocation {
    @Id @GeneratedValue
    @Column(name = "indoor_user_location_id")
    private Long id;

    private LocalDateTime date;

    private Point coordinate;

    private String mapId;

    //연관관계 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uwb_tag_id")
    private UwbTag uwbTag;
}
