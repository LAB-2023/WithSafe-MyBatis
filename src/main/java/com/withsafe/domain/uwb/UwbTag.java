package com.withsafe.domain.uwb;

import com.withsafe.domain.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor
@Getter
public class UwbTag {
    @Id @GeneratedValue
    @Column(name = "uwb_tag_id")
    private Long id;    //PK

    //FK
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;  //태그와 매핑된 유저 io
}
