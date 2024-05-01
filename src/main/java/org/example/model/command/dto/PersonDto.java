package org.example.model.command.dto;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class PersonDto {
    private String dataType;
    private String firstName;
    private String lastName;
    private String identifier;
    private long height;
    private long weight;
    private String email;
}
