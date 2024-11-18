package com.lenncoder.repository;

import com.lenncoder.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Query to check if user id already exists
    Optional<Employee> findEmployeeByUserId(Long userId);
}
