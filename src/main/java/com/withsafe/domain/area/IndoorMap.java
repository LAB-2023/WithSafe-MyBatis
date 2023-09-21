package com.withsafe.domain.area;

import com.withsafe.domain.Beacon;
import com.withsafe.domain.Department;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@RequiredArgsConstructor
public class IndoorMap {

    @Id @GeneratedValue
    @Column(name = "indoor_map_id")
    private Long id;

    private String name;

    private String imageUrl;

    //실내지도가 비콘 리스트를 가지고 있어야하나..? 일단 추가
    @OneToMany(mappedBy = "indoorMap")
    private List<Beacon> beaconList = new ArrayList<>();

    @OneToMany(mappedBy = "indoorMap")
    private List<RestrictArea> restrictAreaList = new ArrayList<>();

    //연관관계 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;


    /*연관관계 편의 메서드*/
    public void setDepartment(Department department) {
        this.department = department;
        department.getIndoorMapList().add(this);
    }
}
