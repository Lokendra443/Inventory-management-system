package com.lenncoder.controller;

import com.lenncoder.entity.Employee;
import com.lenncoder.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        // checking if the user_id already exists or not
        if(employee.getUserId() != null){
            Long userId = employee.getUserId();

            Optional<Employee> existingEmployee = employeeService.findEmployeeByUserId(userId);
            if(existingEmployee.isPresent()){
                throw new RuntimeException("User id already exists");
            }
        }


        Employee savedEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.ok(savedEmployee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        Employee updatedEmployee = employeeService.updateEmployee(id, employee);
        return updatedEmployee != null ? ResponseEntity.ok(updatedEmployee) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

}
