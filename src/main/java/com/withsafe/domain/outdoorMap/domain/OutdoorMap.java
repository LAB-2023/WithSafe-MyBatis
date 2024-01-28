package com.withsafe.domain.outdoorMap.domain;

import com.withsafe.domain.department.domain.Department;
import com.withsafe.domain.env.domain.EnvSensor;
import com.withsafe.domain.outdoorMap.dto.OutdoorMapDto;
import com.withsafe.domain.outdoorMap.dto.OutdoorMapFindRequestDto;
import com.withsafe.domain.restrictArea.domain.RestrictArea;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Point;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@RequiredArgsConstructor
public class OutdoorMap {

    private Long id;    //PK
    private String name;    //지도 이름
    @Column(columnDefinition = "geometry(Point, 4326)")
    private Point coordinate;   //실외 지도의 중심 위도, 경도
    private List<EnvSensor> envSensorList = new ArrayList<>();  //실외에 설치된 환경센서 목록
    private List<RestrictArea> restrictAreaList = new ArrayList<>();    //실외에 설정된 위험구역의 목록
    private Department department;  //해당 실외 지도를 관리되는 부서

    public static OutdoorMap toEntity(String name, Point point, Department department) {
        return OutdoorMap
                .builder()
                .name(name)
                .coordinate(point)
                .department(department)
                .build();
    }

    public static OutdoorMap toEntity(OutdoorMapFindRequestDto outdoorMapFindRequestDto, Point point) {
        return OutdoorMap
                .builder()
                .id(outdoorMapFindRequestDto.getId())
                .name(outdoorMapFindRequestDto.getMapName())
                .coordinate(point)
                .build();
    }

    /*연관관계 편의 메서드*/
    public void setDepartmentJpa(Department department) {
        this.department = department;
        department.getOutdoorMapList().add(this);
    }

    @Builder
    public OutdoorMap(Long id, String name, Point coordinate, List<EnvSensor> envSensorList,
                      List<RestrictArea> restrictAreaList, Department department) {
        this.id = id;
        this.name = name;
        this.coordinate = coordinate;
        this.envSensorList = envSensorList;
        this.restrictAreaList = restrictAreaList;
        this.department = department;
    }
}
