package com.withsafe.domain.watch.domain;

import com.withsafe.domain.department.domain.Department;
import com.withsafe.domain.helmet.domain.Helmet;
import com.withsafe.domain.user.domain.User;
import com.withsafe.global.BaseTimeDomain;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * TODO: 활동정보 여기에다가 넣는지 문의
 */
@NoArgsConstructor
@Getter
public class Watch extends BaseTimeDomain {
    @Id @GeneratedValue
    @Column(name = "watch_id")
    private Long id;

    private User user;  //워치가 매핑된 유저

    private String serialNum;  //시리얼 번호

    private String model;   //모델 정보

    private Boolean is_used;    //사용유무

    private Integer deviceNum; //디바이스번호(PK와 다름)

    private Helmet helmet;  //워치에 매핑된 턱끈 id

    private Department department;  //해당 사용자가 포함된 부서 id
    @Builder
    public Watch(Long id, User user, String serialNum, String model, Boolean is_used,
                    Integer deviceNum, Helmet helmet, Department department) {
        this.id = id;
        this.user = user;
        this.serialNum = serialNum;
        this.model = model;
        this.is_used = is_used;
        this.deviceNum = deviceNum;
        this.helmet = helmet;
        this.department = department;
    }

    public void updateUser(User user){
        this.user = user;
        this.is_used = (user != null);
    }

    public void updateHelmet(Helmet helmet){
        this.helmet = helmet;
    }
}