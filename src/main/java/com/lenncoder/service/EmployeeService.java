package com.lenncoder.service;

import com.lenncoder.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAllEmployee();
    Optional<Employee> getEmployeeById(Long id);
    Employee saveEmployee(Employee employee);
    Employee updateEmployee(Long id, Employee employee);
    void deleteEmployee(Long id);
    Optional<Employee> findEmployeeByUserId(Long userId);
}
