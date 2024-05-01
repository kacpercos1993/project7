package org.example.model.command.dto;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@SuperBuilder
public class EmployeeDto extends PersonDto {
    private LocalDate hireDate;
    private String jobPosition;
    private double salary;
}
