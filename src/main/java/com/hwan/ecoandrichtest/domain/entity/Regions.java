package com.hwan.ecoandrichtest.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "regions")
public class Regions {
    @Id
    @Column(name = "region_id")
    private Long id;

    @Column(name = "region_name")
    private String name;
}
