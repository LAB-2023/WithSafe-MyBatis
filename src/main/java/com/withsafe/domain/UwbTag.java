package com.withsafe.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UwbTag {
    @Id @GeneratedValue
    private Long id;
}
