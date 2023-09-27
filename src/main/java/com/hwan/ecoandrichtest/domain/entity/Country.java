package com.hwan.ecoandrichtest.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "countries")
public class Country {

    @Id
    @Column(name = "country_id")
    private String id;

    @Column(name = "country_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Regions region;
}
