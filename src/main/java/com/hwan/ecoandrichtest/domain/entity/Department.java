package com.hwan.ecoandrichtest.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter @Setter @ToString
@Table(name = "departments")
public class Department {

    @Id
    @Column(name = "department_id")
    private Long id;

    @Column(name = "department_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees; // employees 필드 추가

    // employees 필드에 대한 게터 추가
    public List<Employee> getEmployees() {
        return employees;
    }
}
