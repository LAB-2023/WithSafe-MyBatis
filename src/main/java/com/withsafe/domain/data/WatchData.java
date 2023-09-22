package com.withsafe.domain.data;

import com.withsafe.domain.device.Watch;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@RequiredArgsConstructor
public class WatchData {

    @Id @GeneratedValue
    @Column(name = "watch_data_id")
    private Long id;    //PK

    private String battery; //워치 배터리 잔량
    private String charge;  //워치의 충전 상태 (방전, 충전중, 충전완료)
    private LocalDateTime date; //데이터가 넘어오는 시간

    //연관관계 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "watch_id")
    private Watch watch;
}
