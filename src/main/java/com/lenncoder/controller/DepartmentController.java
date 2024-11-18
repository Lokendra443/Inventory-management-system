package com.lenncoder.controller;

import com.lenncoder.entity.Department;
import com.lenncoder.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department){
        Department createdDepartment = departmentService.createDepartment(department);
        return new ResponseEntity<>(createdDepartment, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id){
        Department department = departmentService.getDepartmentById(id);
        if(department != null){
            return new ResponseEntity<>(department, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(department, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartment(){
        List<Department> departments = departmentService.getAllDepartment();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department department){
        Department updatedDepartment = departmentService.updateDepartment(id, department);
        return new ResponseEntity<>(updatedDepartment, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id){
        departmentService.deleteDepartment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
