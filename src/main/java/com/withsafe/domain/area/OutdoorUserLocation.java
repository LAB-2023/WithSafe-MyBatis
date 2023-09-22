package com.withsafe.domain.area;

import com.withsafe.domain.device.Watch;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.awt.*;
import java.time.LocalDateTime;

@Entity
@Getter
@RequiredArgsConstructor
public class OutdoorUserLocation {

    @Id @GeneratedValue
    @Column(name = "outdoor_user_location_id")
    private Long id;    //PK

    private Point coordinate;   //실외에서 유저의 위치정보(위도, 경도)

    private LocalDateTime date; //해당 위치 정보가 전송된 시간

    //연관관계 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "watch_id")
    private Watch watch;    //위치 정보를 넘겨주는 워치 id
}
