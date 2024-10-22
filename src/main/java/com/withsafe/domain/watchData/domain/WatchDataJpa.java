package com.withsafe.domain.watchData.domain;

import com.withsafe.domain.BaseTimeEntity;
import com.withsafe.domain.watch.domain.WatchJpa;
import com.withsafe.domain.watchData.dto.WatchDataDTO.SaveRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@RequiredArgsConstructor
public class WatchDataJpa extends BaseTimeEntity {

    @Id @GeneratedValue
    @Column(name = "watch_data_id")
    private Long id;    //PK

    private String battery; //워치 배터리 잔량
    private String charge;  //워치의 충전 상태 (방전, 충전중, 충전완료)
    //private LocalDateTime date; //데이터가 넘어오는 시간

    //연관관계 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "watch_id")
    private WatchJpa watch;

    @Builder
    public WatchDataJpa(Long id, String battery, String charge, WatchJpa watch) {
        this.id = id;
        this.battery = battery;
        this.charge = charge;
        this.watch = watch;
    }

    public void update(SaveRequest updateRequest){
        this.battery = updateRequest.getBattery();
        this.charge = updateRequest.getCharge();
    }
}