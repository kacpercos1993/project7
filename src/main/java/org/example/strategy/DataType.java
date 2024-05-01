package org.example.strategy;

import org.example.model.Employee;
import org.example.model.Person;
import org.example.model.Student;


public enum DataType {
    EMPLOYEE(Employee.class),
    STUDENT(Student.class);

    private final Class<? extends Person> typeClass;


    DataType(Class<? extends Person> typeClass) {
        this.typeClass = typeClass;
    }

    public Class<? extends Person> getTypeClass() {
        return typeClass;
    }
}
