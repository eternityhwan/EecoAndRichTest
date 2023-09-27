package com.hwan.ecoandrichtest.repository;

import com.hwan.ecoandrichtest.domain.entity.Employee;
import com.hwan.ecoandrichtest.domain.entity.JobHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeHistoryRepository extends JpaRepository<JobHistory, Long> {

    List<JobHistory> findByEmployee(Employee employee);
}
