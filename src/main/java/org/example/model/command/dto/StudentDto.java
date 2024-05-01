package org.example.model.command.dto;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class StudentDto extends PersonDto {

    private String nameSchool;
    private String graduationYear;
    private String major;
    private String scholarShip;
}
