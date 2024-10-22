package com.withsafe.domain.watchData.domain;

import com.withsafe.domain.BaseTimeEntity;
import com.withsafe.domain.watch.domain.Watch;
import com.withsafe.domain.watchData.dto.WatchDataDTO.SaveRequest;
import com.withsafe.global.BaseTimeDomain;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Getter
@RequiredArgsConstructor
public class WatchData extends BaseTimeDomain {

    private Long id;    //PK
    private String battery; //워치 배터리 잔량
    private String charge;  //워치의 충전 상태 (방전, 충전중, 충전완료)
    private Watch watch;

    @Builder
    public WatchData(Long id, String battery, String charge, Watch watch) {
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