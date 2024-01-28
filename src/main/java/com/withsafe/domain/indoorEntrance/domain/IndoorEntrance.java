package com.withsafe.domain.indoorEntrance.domain;

import com.withsafe.domain.beacon.domain.Beacon;
import com.withsafe.domain.BaseTimeEntity;
import com.withsafe.domain.indoorEntrance.dto.IndoorEntranceDto;
import com.withsafe.domain.watch.domain.Watch;
import com.withsafe.global.BaseTimeDomain;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Getter
@RequiredArgsConstructor
public class IndoorEntrance extends BaseTimeDomain {

    private Long id;
    //연관관계 매핑
    private Beacon beacon;  //실내 구역 출입을 인지한 비콘의 id
    private Watch watch;    //실내 구역에 출입한 워치 id

    @Builder
    public IndoorEntrance(Long id, Beacon beacon, Watch watch) {
        this.id = id;
        this.beacon = beacon;
        this.watch = watch;
    }

    public static IndoorEntrance toEntity(Beacon beacon, Watch watch){
        return IndoorEntrance
                .builder()
                .beacon(beacon)
                .watch(watch)
                .build();
    }
}
