package com.lenncoder.service;

import com.lenncoder.entity.Department;

import java.util.List;

public interface DepartmentService {

    Department createDepartment(Department department);
    Department getDepartmentById(Long id);
    List<Department> getAllDepartment();
    Department updateDepartment(Long id, Department department);
    void deleteDepartment(Long id);

}
