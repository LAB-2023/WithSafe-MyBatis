package com.withsafe.domain.device;

import com.withsafe.domain.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Watch {
    @Id @GeneratedValue
    @Column(name = "watch_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    private String serial_num;
    private LocalDateTime operating_date;

    private String model;

    private Boolean is_used;

    private int device_num;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "helmet_id")
    private Helmet helmet;
}
