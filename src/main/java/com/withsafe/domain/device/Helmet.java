package com.withsafe.domain.device;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Helmet {
    @Id @GeneratedValue
    @Column(name = "helmet_id")
    private Long id;

    private String serialNum;
    private LocalDateTime openingDate;
    private String model;
    private Boolean is_used;
    private Long deviceNum;

    //FK
    @OneToOne(mappedBy = "watch", fetch = FetchType.LAZY)
    private Watch watch;
}
