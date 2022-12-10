package com.springdata.first.dto;


import com.springdata.first.model.entity.Employee;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private Double salary;

    public static EmployeeDto toDTO(Employee entity) {

        return EmployeeDto.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .salary(entity.getSalary())
                .build();
    }



}
