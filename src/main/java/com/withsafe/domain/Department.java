package com.withsafe.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;
import java.util.ArrayList;

@Entity
@Getter @Setter
public class Department {

    @Id @GeneratedValue
    @Column(name = "department_id")
    private Long id;

    private String name;
    private String userList;
    private String outdoorList;
    private String indoorList;
    //private List<User> users = new ArrayList<>();
}

