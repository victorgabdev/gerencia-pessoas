package com.victorgabdev.gerenciapessoas.modules.person.controller;

import com.victorgabdev.gerenciapessoas.core.person.Person;
import com.victorgabdev.gerenciapessoas.core.person.PersonService;
import com.victorgabdev.gerenciapessoas.modules.person.model.PersonDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping
@RestController("/persons")
public class PersonController {

    PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{personId}")
    public ResponseEntity<PersonDTO> getPerson(@PathVariable Long personId) {
        PersonDTO personDTO = personService.getPersonById(personId);
        return ResponseEntity.ok(personDTO);
    }

    @GetMapping
    public ResponseEntity<List<PersonDTO>> getAllPersons() {
        List<PersonDTO> personDTOS = personService.getAllPersons();
        return ResponseEntity.ok(personDTOS);
    }

    @PostMapping("/create")
    public ResponseEntity<PersonDTO> createPerson(@RequestBody Person person) {
        PersonDTO personDTO = personService.createPerson(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(personDTO);
    }

    // update pessoa
    @PutMapping("/update")
    public ResponseEntity<PersonDTO> updatePerson(@RequestBody Person person) {
        PersonDTO personDTO = personService.updatePerson(person);
        return ResponseEntity.ok(personDTO);
    }

    // deleta pessoa
    @DeleteMapping("delete/{personId}")
    public ResponseEntity<PersonDTO> deletePerson(@PathVariable Long personId) {
        personService.deletePerson(personId);
        return ResponseEntity.noContent().build();
    }
}
