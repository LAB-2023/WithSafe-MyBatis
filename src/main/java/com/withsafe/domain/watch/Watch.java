package com.withsafe.domain.watch;

import com.withsafe.domain.BaseTimeEntity;
import com.withsafe.domain.User;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Watch extends BaseTimeEntity {
    @Id @GeneratedValue
    @Column(name = "watch_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;  //워치가 매핑된 유저 id

    private String serial_num;  //시리얼 번호
    //private LocalDateTime operating_date;   //개통일

    private String model;   //모델 정보

    private Boolean is_used;    //사용유무

    private int device_num; //디바이스번호(PK와 다름)

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "watch")
    private Helmet helmet;  //워치에 매핑된 턱끈 id

}
