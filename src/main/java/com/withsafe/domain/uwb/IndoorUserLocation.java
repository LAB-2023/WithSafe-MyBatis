package com.withsafe.domain.uwb;

import com.withsafe.domain.BaseTimeEntity;
import com.withsafe.domain.uwb.UwbTag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Point;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Getter
@RequiredArgsConstructor
public class IndoorUserLocation extends BaseTimeEntity {
    @Id @GeneratedValue
    @Column(name = "indoor_user_location_id")
    private Long id;    //PK

    //private LocalDateTime date; //유저의 실내에서의 위치 데이터가 전송된 시간

    private Point coordinate;   //유저의 위치(좌표)

    private String mapId;   //좌표와 함꼐 uwb앵커로부터 넘어오는 실내 지도 id

    //연관관계 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uwb_tag_id")
    private UwbTag uwbTag;
}
