package com.hwan.ecoandrichtest.service;

import com.hwan.ecoandrichtest.domain.entity.Department;
import com.hwan.ecoandrichtest.domain.entity.Employee;
import com.hwan.ecoandrichtest.repository.DepartmentRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Transactional
    public void increaseSalaryForDepartmentByName(String departmentName, BigDecimal salaryIncreasePercentage) {
        // 부서 이름을 기반으로 해당 부서를 조회합니다.
        Department department = departmentRepository.findByName(departmentName);

        if (department == null) {
            throw new EntityNotFoundException("Department not found with name: " + departmentName);
        }

        // 부서의 사원 목록을 가져와서 급여를 인상하는 로직을 작성합니다.
        List<Employee> employees = department.getEmployees();
        for (Employee employee : employees) {
            BigDecimal currentSalary = employee.getSalary();
            BigDecimal salaryIncrease = currentSalary.multiply(salaryIncreasePercentage);
            BigDecimal newSalary = currentSalary.add(salaryIncrease);
            employee.setSalary(newSalary);
        }
        // 변경 내용을 데이터베이스에 반영합니다.
        departmentRepository.save(department);
    }
}

