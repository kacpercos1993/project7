package org.example.strategy;

import org.example.model.Person;
import org.example.model.command.dto.PersonDto;

public interface DtoFactory<T extends PersonDto> {

    T mapToDto(Person person);
}
