package com.withsafe.domain.department.domain;

import com.withsafe.domain.BaseTimeEntity;
import com.withsafe.domain.department.dto.DepartmentDTO.saveDepartment;
import com.withsafe.domain.outdoorMap.domain.OutdoorMap;
import com.withsafe.domain.indoorMap.domain.IndoorMap;
import com.withsafe.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Getter
@RequiredArgsConstructor
public class Department extends BaseTimeEntity{

    @Id @GeneratedValue
    @Column(name = "department_id")
    private Long id;

    private String name;    //부서 이름

    @OneToMany(mappedBy = "department")
    private List<User> userList = new ArrayList<>();    //부서에 포함된 유저 목록

    @OneToMany(mappedBy = "department")
    private List<OutdoorMap> outdoorMapList = new ArrayList<>();    //부서에 포함된 실외지도 목록

    @OneToMany(mappedBy = "department")
    private List<IndoorMap> indoorMapList = new ArrayList<>();  //부서에 포함된 실내지도 목록

    @Builder
    public Department(String name) {
        this.name = name;
    }

    public saveDepartment toSaveDepartmentDTO() {
        return new saveDepartment(this.name);
    }
}

