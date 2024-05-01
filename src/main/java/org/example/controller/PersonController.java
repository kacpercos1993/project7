package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.model.command.CreatePersonCommand;
import org.example.model.command.UpdatePersonCommand;
import org.example.model.command.dto.PersonDto;
import org.example.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stuff")
@RequiredArgsConstructor
@Slf4j
public class PersonController {

    private final PersonService personService;

    @PostMapping
    public PersonDto save(@RequestBody CreatePersonCommand command) {
        return personService.save(command);
    }

    @GetMapping
    public List<PersonDto> findall() {
        return personService.findByCriteria();
    }

    @PutMapping("/{identifier}")
    public void update(@PathVariable("identifier") String identifier, @RequestBody UpdatePersonCommand command) {
        personService.update(identifier, command);
    }
}
