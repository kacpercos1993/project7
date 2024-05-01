package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.model.Person;
import org.example.model.command.CreatePersonCommand;
import org.example.model.command.UpdatePersonCommand;
import org.example.model.command.dto.PersonDto;
import org.example.repository.PersonRepository;
import org.example.strategy.BuildingStrategy;
import org.example.strategy.DataType;
import org.example.strategy.EmployeeFactory;
import org.example.strategy.StudentFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PersonService {
    private final BuildingStrategy buildingStrategy;
    private final PersonRepository personRepository;

    public PersonDto save(CreatePersonCommand command) {
        Person person = buildingStrategy.createFromRawData(command);
        return buildingStrategy.createDto(personRepository.save(person));
    }

    public List<PersonDto> findByCriteria() {
        return personRepository.findAll()
                .stream()
                .map(buildingStrategy::createDto)
                .toList();
    }

    public void update(String identifier , UpdatePersonCommand command) {
        Person toUpdate = personRepository.findPersonByIdentifier(identifier);
        buildingStrategy.updateEntity(toUpdate,command);
//        log.info("{}", buildingStrategy.updateEntity(toUpdate , command));
        personRepository.save(toUpdate);
    }

    @Bean
    public BuildingStrategy registerEmployeeFactory() {
        return buildingStrategy.registerFactory(DataType.EMPLOYEE.name().toLowerCase(), new EmployeeFactory());
    }

    @Bean
    public BuildingStrategy registerStudentFactory() {
        return buildingStrategy.registerFactory(DataType.STUDENT.name().toLowerCase(), new StudentFactory());
    }

    @Bean
    public BuildingStrategy registerDtoEmployeeFactory() {
        return buildingStrategy.registerDtoFactory(DataType.EMPLOYEE.name().toLowerCase(), new EmployeeFactory());
    }
    @Bean
    public BuildingStrategy registerDtoStudentFactory() {
        return buildingStrategy.registerDtoFactory(DataType.STUDENT.name().toLowerCase(), new StudentFactory());
    }

    @Bean
    public BuildingStrategy registerUpdateFactory() {
        return buildingStrategy.registerUpdateFactory("employee", new EmployeeFactory());
    }
}

