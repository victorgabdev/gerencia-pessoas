package com.victorgabdev.gerenciapessoas.core.person;

import com.victorgabdev.gerenciapessoas.modules.person.model.PersonDTO;

import java.util.List;


public interface PersonService {
    List<PersonDTO> getAllPersons();
    PersonDTO getPersonById(Long id);
    PersonDTO createPerson(Person person);
    PersonDTO updatePerson(Person updatedPerson);
    void deletePerson(Long id);
}
