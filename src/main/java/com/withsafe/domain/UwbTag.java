package com.withsafe.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class UwbTag {
    @Id @GeneratedValue
    @Column(name = "uwb_tag_id")
    private Long id;

    //FK
    private Long user;
}
