package com.hwan.ecoandrichtest.repository;

import com.hwan.ecoandrichtest.domain.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long > {
}
