package com.hwan.ecoandrichtest.repository;

import com.hwan.ecoandrichtest.domain.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // 부서 이름으로 부서를 조회하는 메서드 추가
    Department findByName(String name);
}
