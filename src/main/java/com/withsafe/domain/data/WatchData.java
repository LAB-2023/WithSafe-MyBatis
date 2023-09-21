package com.withsafe.domain.data;

import com.withsafe.domain.device.Watch;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class WatchData {

    @Id @GeneratedValue
    @Column(name = "watch_data_id")
    private Long id;

    private String battery;
    private String charge;
    private LocalDateTime date;

    //연관관계 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "watch_id")
    private Watch watch;
}
