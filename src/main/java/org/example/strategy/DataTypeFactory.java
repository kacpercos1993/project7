package org.example.strategy;

import org.example.model.Person;
import org.example.model.command.CreatePersonCommand;

public interface DataTypeFactory<T extends Person> {
    T create(CreatePersonCommand command);

}
