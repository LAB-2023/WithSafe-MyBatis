package com.withsafe.domain.area;

import com.withsafe.domain.Department;
import com.withsafe.domain.device.EnvSensor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@RequiredArgsConstructor
public class OutdoorMap {

    @Id @GeneratedValue
    @Column(name = "outdoor_map_id")
    private Long id;    //PK

    private String name;    //지도 이름
    private Point coordinate;   //실외 지도의 중심 위도, 경도

    @OneToMany(mappedBy = "outdoorMap")
    private List<EnvSensor> envSensorList = new ArrayList<>();  //실외에 설치된 환경센서 목록

    @OneToMany(mappedBy = "outdoorMap")
    private List<RestrictArea> restrictAreaList = new ArrayList<>();    //실외에 설정된 위험구역의 목록

    //연관관계 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;  //해당 실외 지도를 관리되는 부서

    /*연관관계 편의 메서드*/
    public void setDepartment(Department department) {
        this.department = department;
        department.getOutdoorMapList().add(this);
    }
}
