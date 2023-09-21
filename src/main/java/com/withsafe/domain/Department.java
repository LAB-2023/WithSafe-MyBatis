package com.withsafe.domain;

import com.withsafe.domain.area.IndoorMap;
import com.withsafe.domain.area.OutdoorMap;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Getter @Setter
public class Department {

    @Id @GeneratedValue
    @Column(name = "department_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "department")
    private List<User> userList = new ArrayList<>();

    @OneToMany(mappedBy = "department")
    private List<OutdoorMap> outdoorMapList = new ArrayList<>();

    @OneToMany(mappedBy = "department")
    private List<IndoorMap> indoorMapList = new ArrayList<>();
}

