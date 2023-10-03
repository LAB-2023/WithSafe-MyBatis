package com.withsafe.domain.helmet.domain;

import com.withsafe.domain.BaseTimeEntity;
import com.withsafe.domain.watch.domain.Watch;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor
@Getter
public class Helmet extends BaseTimeEntity {
    @Id @GeneratedValue
    @Column(name = "helmet_id")
    private Long id;

    private String serialNum;   //시리얼번호
    //private LocalDateTime openingDate;  //개통일
    private String model;   //모델 정보
    private Boolean is_used;    //사용유무
    private Long deviceNum; //디바이스번호 (PK와 다름)

    //FK
    @OneToOne(mappedBy = "helmet", fetch = FetchType.LAZY)
    private Watch watch;

    @Builder
    public Helmet(Long id, String serialNum, String model, Boolean is_used, Long deviceNum, Watch watch){
        this.id = id;
        this.serialNum = serialNum;
        this.model = model;
        this.is_used = is_used;
        this.deviceNum = deviceNum;
        this.watch = watch;
    }
}
