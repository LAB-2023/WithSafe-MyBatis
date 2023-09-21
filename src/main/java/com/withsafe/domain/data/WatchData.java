package com.withsafe.domain.data;

import com.withsafe.domain.device.Watch;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class WatchData {

    @Id @GeneratedValue
    private Long id;

    private String battery;
    private String charge;
    private LocalDateTime date;

    //연관관계 매핑
    @ManyToOne
    private Watch watch;
}
