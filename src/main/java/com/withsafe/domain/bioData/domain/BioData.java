package com.withsafe.domain.bioData.domain;

import com.withsafe.domain.BaseTimeEntity;
import com.withsafe.domain.user.domain.User;
import com.withsafe.domain.watch.domain.Watch;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class BioData extends BaseTimeEntity {  //워치에서 넘어오는 유저의 생체 데이터
    @Id @GeneratedValue
    @Column(name = "bio_data_id")
    private Long id;
    private Integer heartRate;     //심장박동수
    private Double temperature; //체온
    private Integer walkCount;  //걸음수
    private Double oxygen;  //산소포화도
    private Integer calorie; //칼로리
    private Boolean isFall; //낙상 여부
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public BioData(Long id, Integer heartRate, Double temperature, Integer walkCount, Double oxygen, User user, Integer calorie, Boolean isFall) {
        this.id = id;
        this.heartRate = heartRate;
        this.temperature = temperature;
        this.walkCount = walkCount;
        this.oxygen = oxygen;
        this.user = user;
        this.calorie = calorie;
        this.isFall = isFall;
    }
}
