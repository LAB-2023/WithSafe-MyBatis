package com.withsafe.domain.area;

import com.withsafe.domain.Department;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Getter @Setter
@RequiredArgsConstructor
public class IndoorMap {

    @Id @GeneratedValue
    private Long id;

    private String name;

    private String imageUrl;

    //연관관계 매핑
    @OneToOne
    private Department department;
}
