package com.withsafe.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;
import java.util.ArrayList;

@Entity
public class Department {

    @Id @GeneratedValue
    @Column(name = "department_id")
    private Long id;
    private String name;
    private List<User> users = new ArrayList<>();
}

