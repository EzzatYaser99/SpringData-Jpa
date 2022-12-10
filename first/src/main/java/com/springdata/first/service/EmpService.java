package com.springdata.first.service;


import com.springdata.first.dto.EmployeeDto;
import com.springdata.first.model.entity.Employee;
import com.springdata.first.repositiory.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {
    @Autowired
    private EmpRepo empRepo;

    public EmployeeDto getEmp(Integer id) {
        Optional<Employee> emp = this.empRepo.findById(id);
        if (emp.isPresent()) return EmployeeDto.toDTO(emp.get());
        else return null;

    }

    public EmployeeDto saveEmp(EmployeeDto employee) {
     return EmployeeDto.toDTO(empRepo.save(Employee.toEntity(employee)));

    }

    public void deleteEmp(Integer id) {
        this.empRepo.deleteById(id);
    }

    public List<Employee> getAllEmp() {
        return this.empRepo.findAll();
    }
}
