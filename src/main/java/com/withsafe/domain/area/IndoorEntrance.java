package com.withsafe.domain.area;

import com.withsafe.domain.Beacon;
import com.withsafe.domain.device.Watch;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@RequiredArgsConstructor
public class IndoorEntrance {

    @Id
    @GeneratedValue
    @Column(name = "indoor_entrance_id")
    private Long id;

    private LocalDateTime exit_time;

    private LocalDateTime enter_time;

    //연관관계 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "beacon_id")
    private Beacon beacon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "watch_id")
    private Watch watch;
}
