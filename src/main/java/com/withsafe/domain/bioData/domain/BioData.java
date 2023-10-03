package com.withsafe.domain.bioData.domain;

import com.withsafe.domain.BaseTimeEntity;
import com.withsafe.domain.watch.domain.Watch;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BioData extends BaseTimeEntity {  //워치에서 넘어오는 유저의 생체 데이터
    @Id @GeneratedValue
    @Column(name = "bio_data_id")
    private Long id;
    private Integer heartRate;     //심장박동수
    private Double temperature; //체온
    //private LocalDateTime date; //데이터가 넘어오는 시간
    private Integer walkCount;  //걸음수
    private Double oxygen;  //산소포화도

    //연관관계 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "watch_id")
    private Watch watch;

    @Builder
    public BioData(Long id, Integer heartRate, Double temperature, Integer walkCount, Double oxygen, Watch watch) {
        this.id = id;
        this.heartRate = heartRate;
        this.temperature = temperature;
        this.walkCount = walkCount;
        this.oxygen = oxygen;
        this.watch = watch;
    }
}
