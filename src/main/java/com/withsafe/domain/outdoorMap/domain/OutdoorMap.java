package com.withsafe.domain.outdoorMap.domain;

import com.withsafe.domain.department.domain.DepartmentJpa;

import com.withsafe.domain.env.domain.EnvSensor;
import com.withsafe.domain.restrictArea.domain.RestrictArea;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Point;

import javax.persistence.*;
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

    @Column(columnDefinition = "geometry(Point, 4326)")
    private Point coordinate;   //실외 지도의 중심 위도, 경도

    @OneToMany(mappedBy = "outdoorMap")
    private List<EnvSensor> envSensorList = new ArrayList<>();  //실외에 설치된 환경센서 목록

    @OneToMany(mappedBy = "outdoorMap")
    private List<RestrictArea> restrictAreaList = new ArrayList<>();    //실외에 설정된 위험구역의 목록

    //연관관계 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private DepartmentJpa departmentJpa;  //해당 실외 지도를 관리되는 부서

    /*연관관계 편의 메서드*/
    public void setDepartmentJpa(DepartmentJpa departmentJpa) {
        this.departmentJpa = departmentJpa;
        departmentJpa.getOutdoorMapList().add(this);
    }

    @Builder
    public OutdoorMap(Long id, String name, Point coordinate, List<EnvSensor> envSensorList,
                      List<RestrictArea> restrictAreaList, DepartmentJpa departmentJpa) {
        this.id = id;
        this.name = name;
        this.coordinate = coordinate;
        this.envSensorList = envSensorList;
        this.restrictAreaList = restrictAreaList;
        this.departmentJpa = departmentJpa;
    }
}
