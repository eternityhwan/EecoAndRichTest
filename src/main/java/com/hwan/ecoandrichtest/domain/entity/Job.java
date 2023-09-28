package com.hwan.ecoandrichtest.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



import java.math.BigDecimal;

@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @Column(name = "job_id")
    private String id;

    @Column(name = "job_title")
    private String title;

    @Column(name = "min_salary")
    private BigDecimal minSalary;

    @Column(name = "max_salary")
    private BigDecimal maxSalary;

}