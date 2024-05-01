package org.example.strategy;

import org.example.model.Person;
import org.example.model.Student;
import org.example.model.command.CreatePersonCommand;
import org.example.model.command.dto.StudentDto;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("student")
public class StudentFactory implements DataTypeFactory<Student>,DtoFactory<StudentDto> {

    @Override
    public Student create(CreatePersonCommand command) {
        Map<String, String> params = command.getParams();
        return Student.builder()
                .dataType(command.getDataType().toLowerCase())
                .firstName(params.get("firstName"))
                .lastName(params.get("lastName"))
                .identifier(params.get("identifier"))
                .height(Long.parseLong(params.get("height")))
                .weight(Long.parseLong(params.get("weight")))
                .email(params.get("email"))
                .nameSchool(params.get("nameSchool"))
                .graduationYear(params.get("graduationYear"))
                .major(params.get("major"))
                .scholarShip(params.get("scholarShip"))
                .build();
    }



    @Override
    public StudentDto mapToDto(Person person) {
        if (person instanceof Student student) {
            return StudentDto.builder()
                    .dataType(person.getDataType())
                    .firstName(person.getFirstName())
                    .lastName(person.getLastName())
                    .identifier(person.getIdentifier())
                    .height(person.getHeight())
                    .weight(person.getWeight())
                    .email(person.getEmail())
                    .nameSchool(student.getNameSchool())
                    .graduationYear(student.getGraduationYear())
                    .major(student.getMajor())
                    .scholarShip(student.getScholarShip())
                    .build();
        } else {
            throw new IllegalArgumentException("Person is not an instance of Employee");
        }
    }
}
