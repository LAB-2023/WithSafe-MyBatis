package com.withsafe.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class UwbTag {
    @Id @GeneratedValue
    private Long id;

    //FK
    private Long user;
}
