package com.withsafe.domain.watch.domain;

import com.withsafe.domain.BaseTimeEntity;
import com.withsafe.domain.department.domain.DepartmentJpa;
import com.withsafe.domain.helmet.domain.HelmetJpa;
import com.withsafe.domain.user.domain.UserJpa;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * TODO: 활동정보 여기에다가 넣는지 문의
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
public class WatchJpa extends BaseTimeEntity {
    @Id @GeneratedValue
    @Column(name = "watch_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private UserJpa user;  //워치가 매핑된 유저

    private String serialNum;  //시리얼 번호

    private String model;   //모델 정보

    private Boolean is_used;    //사용유무

    private Integer deviceNum; //디바이스번호(PK와 다름)

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "helmet_id")
    private HelmetJpa helmet;  //워치에 매핑된 턱끈 id

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private DepartmentJpa departmentJpa;  //해당 사용자가 포함된 부서 id
    @Builder
    public WatchJpa(Long id, UserJpa user, String serialNum, String model, Boolean is_used,
                    Integer deviceNum, HelmetJpa helmet, DepartmentJpa departmentJpa) {
        this.id = id;
        this.user = user;
        this.serialNum = serialNum;
        this.model = model;
        this.is_used = is_used;
        this.deviceNum = deviceNum;
        this.helmet = helmet;
        this.departmentJpa = departmentJpa;
    }
}