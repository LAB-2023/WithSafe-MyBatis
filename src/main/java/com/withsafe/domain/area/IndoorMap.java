package com.withsafe.domain.area;

import com.withsafe.domain.Department;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@RequiredArgsConstructor
public class IndoorMap {

    @Id @GeneratedValue
    @Column(name = "indoor_map_id")
    private Long id;

    private String name;

    private String imageUrl;

    //연관관계 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;
}
