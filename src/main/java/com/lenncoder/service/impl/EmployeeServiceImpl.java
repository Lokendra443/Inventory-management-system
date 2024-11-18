package com.lenncoder.service.impl;

import com.lenncoder.entity.Employee;
import com.lenncoder.repository.EmployeeRepository;
import com.lenncoder.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee saveEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {

        Optional<Employee> existingEmployee = employeeRepository.findById(id);
        if (existingEmployee.isPresent()) {
            Employee updatedEmployee = existingEmployee.get();
            updatedEmployee.setName((employee.getName()));
            updatedEmployee.setJobTitle(employee.getJobTitle());
            return employeeRepository.save(updatedEmployee);
        } else {
            return null;
        }

    }

    @Override
    public void deleteEmployee(Long id) {

        employeeRepository.deleteById(id);
    }

    @Override
    public Optional<Employee> findEmployeeByUserId(Long userId) {
        return employeeRepository.findEmployeeByUserId(userId);
    }
}
