package org.example.mapper;

import org.example.model.Employee;
import org.example.model.Student;
import org.example.model.command.dto.EmployeeDto;
import org.example.model.command.dto.StudentDto;

public class PersonMapper {

    public static StudentDto mapToDto(Student student) {
        return StudentDto.builder()
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .identifier(student.getIdentifier())
                .height(student.getHeight())
                .weight(student.getWeight())
                .email(student.getEmail())
                .build();
    }
    public static EmployeeDto mapToDto(Employee employee) {
        return EmployeeDto.builder()
                .firstName(employee.getFirstName())
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
