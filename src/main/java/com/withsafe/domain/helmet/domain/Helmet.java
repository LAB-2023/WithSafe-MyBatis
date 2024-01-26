package com.withsafe.domain.helmet.domain;

import com.withsafe.domain.department.domain.Department;
import com.withsafe.domain.watch.domain.Watch;
import com.withsafe.global.BaseTimeDomain;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@RequiredArgsConstructor
@Getter
public class Helmet extends BaseTimeDomain {

    private Long id;

    private String serialNum;   //시리얼번호
    private String model;   //모델 정보
    private Boolean is_used;    //사용유무
    private String deviceNum; //디바이스번호 (PK와 다름)

    //FK
    private Watch watch;
    private Department department;

    @Builder
    public Helmet(Long id, String serialNum, String model, Boolean is_used, String deviceNum, Watch watch, Department department){
        this.id = id;
        this.serialNum = serialNum;
        this.model = model;
        this.is_used = is_used;
        this.deviceNum = deviceNum;
        this.watch = watch;
        this.department = department;
    }

    public void updateUsed() {
        this.is_used = true;
    }
}
