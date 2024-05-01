package org.example.strategy;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.expcetion.UnsupportedTypeException;
import org.example.model.Person;
import org.example.model.command.CreatePersonCommand;
import org.example.model.command.UpdatePersonCommand;
import org.example.model.command.dto.PersonDto;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@Getter
@RequiredArgsConstructor
public class BuildingStrategy {

    private final HashMap</*DataType*/String , DataTypeFactory<? extends Person>> factories = new HashMap<>();
    private final HashMap<String , DtoFactory<? extends PersonDto>> dtoFactories = new HashMap<>();
    private final HashMap<String , UpdatePersonFactory<? extends Person>> updateFactories = new HashMap<>();

    public BuildingStrategy registerFactory(/*DataType*/String dataType , DataTypeFactory<? extends Person> factory) {
        if (factories.containsKey(dataType)) {
            throw new IllegalStateException("try to re-register data type");
        }
        factories.put(dataType, factory);
      return this;
    }
    public BuildingStrategy registerUpdateFactory(/*DataType*/String dataType , UpdatePersonFactory<? extends Person> factory) {
        if (updateFactories.containsKey(dataType)) {
            throw new IllegalStateException("try to re-register data type");
        }
        updateFactories.put(dataType, factory);
        return this;
    }

    public BuildingStrategy registerDtoFactory(String dataType , DtoFactory<? extends PersonDto> factory) {
        if (dtoFactories.containsKey(dataType)) {
            throw new IllegalStateException("try to re-register data type");
        }
        dtoFactories.put(dataType , factory);
        return this;
    }

    @SuppressWarnings("unchecked")
    public <T extends Person> T createFromRawData(CreatePersonCommand dataInput) {
        return (T) this.factories.computeIfAbsent(dataInput.getDataType().toLowerCase(), k ->{
            throw new UnsupportedTypeException("unknown type " + dataInput.getDataType());
        }).create(dataInput);
    }

    public /*<T extends PersonDto>*/ PersonDto createDto(Person dataInput) {
        return dtoFactories.computeIfAbsent(dataInput.getDataType().toLowerCase(), k ->{
            throw new UnsupportedTypeException("xxxx" + dataInput.getDataType());
        }).mapToDto(dataInput);
    }

    public void updateEntity(Person person , UpdatePersonCommand command) {
        updateFactories.computeIfAbsent(command.getDataType().toLowerCase(), k -> {
            throw new UnsupportedTypeException("unsupported data type "+ command.getDataType());
        }).updateEntity(person , command);

    }
}
