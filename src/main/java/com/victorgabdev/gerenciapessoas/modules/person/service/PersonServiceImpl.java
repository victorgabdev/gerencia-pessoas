package com.victorgabdev.gerenciapessoas.modules.person.service;

import com.victorgabdev.gerenciapessoas.core.person.Person;
import com.victorgabdev.gerenciapessoas.core.person.PersonRepository;
import com.victorgabdev.gerenciapessoas.core.person.PersonService;
import com.victorgabdev.gerenciapessoas.shared.exceptions.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
    public List<Person> getAllPersons() {
        return Collections.emptyList();
    }

    @Override
    public Person getPersonById(Long id) {
        Optional<Person> personOpt = personRepository.findById(id);
        if(!personOpt.isPresent()) throw new CustomException("Usuário não existe", HttpStatus.NOT_FOUND);
        return personOpt.get();

    }

    @Override
    public Person createPerson(Person person) {
        return null;
    }

    @Override
    public Person updatePerson(Long id, Person updatedPerson) {
        return null;
    }

    @Override
    public void deletePerson(Long id) {

    }

    @Override
    public void setPrimaryAddress(Long personId, Long addressId) {

    }
}
