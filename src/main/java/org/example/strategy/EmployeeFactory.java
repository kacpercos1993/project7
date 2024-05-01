package org.example.strategy;

import org.example.model.Employee;
import org.example.model.Person;
import org.example.model.command.CreatePersonCommand;
import org.example.model.command.UpdatePersonCommand;
import org.example.model.command.dto.EmployeeDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Map;

@Component("employee")
public class EmployeeFactory implements DataTypeFactory<Employee>,DtoFactory<EmployeeDto>, UpdatePersonFactory<Employee> {
    @Override
    public Employee create(CreatePersonCommand command) {
        Map<String, String> params = command.getParams();
        return Employee.builder()
                .dataType(command.getDataType().toLowerCase())
                .firstName(params.get("firstName"))
                .lastName(params.get("lastName"))
                .identifier(params.get("identifier"))
                .height(Long.parseLong(params.get("height")))
                .weight(Long.parseLong(params.get("weight")))
                .email(params.get("email"))
                .hireDate(LocalDate.parse(params.get("hireDate")))
                .jobPosition(params.get("jobPosition"))
                .salary(Double.parseDouble(params.get("salary")))
                .build();
    }

    @Override
    public EmployeeDto mapToDto(Person person) {
        if (person instanceof Employee employee) {
            return EmployeeDto.builder()
                    .dataType(person.getDataType())
                    .firstName(person.getFirstName())
                    .lastName(person.getLastName())
                    .identifier(person.getIdentifier())
                    .height(person.getHeight())
                    .weight(person.getWeight())
                    .email(person.getEmail())
                    .hireDate(employee.getHireDate())
                    .jobPosition(employee.getJobPosition())
                    .salary(employee.getSalary())
                    .build();
        } else {
            throw new IllegalArgumentException("Person is not an instance of Employee");
        }
    }

    @Override
    public void updateEntity(Person person, UpdatePersonCommand command) {
        Map<String, String> params = command.getParams();
        if (person instanceof Employee employee) {
            if (person.getFirstName() != null) {
                person.setFirstName(params.get("firstName"));
            }
            if (employee.getJobPosition() != null) {
                employee.setJobPosition(params.get("jobPosition"));
            }
        }
    }


}
