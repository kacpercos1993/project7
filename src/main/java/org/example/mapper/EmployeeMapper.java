package org.example.mapper;

import org.example.model.Employee;
import org.example.model.command.dto.EmployeeDto;

public class EmployeeMapper {

    public static EmployeeDto mapToDto(Employee employee) {
        return EmployeeDto.builder()
                .lastName(employee.getLastName())
                .identifier(employee.getIdentifier())
                .height(employee.getHeight())
                .weight(employee.getWeight())
                .email(employee.getEmail())
                .hireDate(employee.getHireDate())
                .jobPosition(employee.getJobPosition())
                .salary(employee.getSalary())
                .build();
    }

}
