package com.victorgabdev.gerenciapessoas.core.person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    List<Person> getAllPersons();
    Optional<Person> getPersonById(Long id);
    Person createPerson(Person person);
    Person updatePerson(Long id, Person updatedPerson);
    void deletePerson(Long id);
    void setPrimaryAddress(Long personId, Long addressId);
}
