package com.springdata.first.controller;


import com.springdata.first.dto.EmployeeDto;
import com.springdata.first.model.entity.Employee;
import com.springdata.first.repositiory.EmpRepo;
import com.springdata.first.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmpService empService;
    @Autowired
    private EmpRepo empRepo;

    @GetMapping("/get-emp")
    public EmployeeDto getUser(@RequestParam Integer id) {
        return empService.getEmp(id);
    }

    @PostMapping("/save-emp")
    public EmployeeDto saveUser(@RequestBody EmployeeDto employee) {
        return (empService.saveEmp(employee));
    }

    @GetMapping("/delete-emp")
    public void deleteUser(@RequestParam Integer id) {
        empService.deleteEmp(id);
    }

    @PostMapping("/update-emp")
    public EmployeeDto updateUser(@RequestBody EmployeeDto employee) {
        return empService.saveEmp(employee);
    }

    @GetMapping("/get-all")
    public List<Employee> getAll() {
        return this.empService.getAllEmp();
    }
}
