package org.example.repository;

import org.example.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Query(value = "select * from Person p where type =:type" , nativeQuery = true)
    Person findBy(@Param("type") String type);

    Person findPersonByIdentifier( String identifier);


}
