package com.withsafe.domain.outdoorUserLocation.domain;

import com.withsafe.domain.BaseTimeEntity;
import com.withsafe.domain.watch.domain.WatchJpa;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.awt.*;

@Entity
@Getter
@RequiredArgsConstructor
public class OutdoorUserLocation extends BaseTimeEntity {

    @Id @GeneratedValue
    @Column(name = "outdoor_user_location_id")
    private Long id;    //PK

    @Column(columnDefinition = "geometry(Point, 4326)")
    private Point coordinate;   //실외에서 유저의 위치정보(위도, 경도)

    //private LocalDateTime date; //해당 위치 정보가 전송된 시간

    //연관관계 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "watch_id")
    private WatchJpa watch;    //위치 정보를 넘겨주는 워치 id

    @Builder
    public OutdoorUserLocation(Long id, Point coordinate, WatchJpa watch) {
        this.id = id;
        this.coordinate = coordinate;
        this.watch = watch;
    }
}
