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
    private Long id;

    private String name;
    private Point coordinate;

    @OneToMany(mappedBy = "outdoorMap")
    private List<EnvSensor> envSensorList = new ArrayList<>();

    @OneToMany(mappedBy = "outdoorMap")
    private List<RestrictArea> restrictAreaList = new ArrayList<>();

    //연관관계 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    /*연관관계 편의 메서드*/
    public void setDepartment(Department department) {
        this.department = department;
        department.getOutdoorMapList().add(this);
    }
}
