package com.withsafe.domain.indoorEntrance.domain;

import com.withsafe.domain.beacon.domain.BeaconJpa;
import com.withsafe.domain.BaseTimeEntity;
import com.withsafe.domain.watch.domain.WatchJpa;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@RequiredArgsConstructor
public class IndoorEntranceJpa extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "indoor_entrance_id")
    private Long id;

    //private LocalDateTime exit_time;    //실내 구역 입장 시간

    //private LocalDateTime enter_time;   //실내 구역 퇴장 시간

    //연관관계 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "beacon_id")
    private BeaconJpa beacon;  //실내 구역 출입을 인지한 비콘의 id

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "watch_id")
    private WatchJpa watch;    //실내 구역에 출입한 워치 id

//    @Builder
//    public IndoorEntrance(Long id, Beacon beacon, Watch watch) {
//        super();
//        this.id = id;
//        this.beacon = beacon;
//        this.watch = watch;
//    }

    @Builder
    public IndoorEntranceJpa(Long id, BeaconJpa beacon, WatchJpa watch) {
        this.id = id;
        this.beacon = beacon;
        this.watch = watch;
    }
}
