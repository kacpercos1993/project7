package org.example.strategy;

import org.example.model.Person;
import org.example.model.command.UpdatePersonCommand;

public interface UpdatePersonFactory<T extends Person>{

    void updateEntity(Person person, UpdatePersonCommand command);
}
