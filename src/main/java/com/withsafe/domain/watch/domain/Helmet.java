package com.withsafe.domain.watch.domain;

import com.withsafe.domain.BaseTimeEntity;
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
}
