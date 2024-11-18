package com.lenncoder.service.impl;

import com.lenncoder.entity.Department;
import com.lenncoder.repository.DepartmentRepository;
import com.lenncoder.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        Department updatedDepartment = departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department not found with id: "+id));
        updatedDepartment.setName(department.getName());
        return departmentRepository.save(updatedDepartment);
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
