package com.victorgabdev.gerenciapessoas.modules.person.service;

import com.victorgabdev.gerenciapessoas.core.person.Person;
import com.victorgabdev.gerenciapessoas.modules.person.model.PersonDTO;
import com.victorgabdev.gerenciapessoas.modules.person.repository.PersonRepository;
import com.victorgabdev.gerenciapessoas.core.person.PersonService;
import com.victorgabdev.gerenciapessoas.shared.exceptions.CustomException;
import com.victorgabdev.gerenciapessoas.util.ServiceUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
    public List<PersonDTO> getAllPersons() {
        List<Person> persons = personRepository.findAll();

        return persons
                .stream()
                .map(person -> PersonDTO.fromPerson(person))
                .collect(Collectors.toList());
    }

    @Override
    public PersonDTO getPersonById(Long id) {
        Person person = getPersonByIdOrThrow(id);
        return PersonDTO.fromPerson(person);
    }

    @Override
    public PersonDTO createPerson(Person person) {
        Optional<Person> personOpt = personRepository.findByFullName(person.getFullName());
        if (personOpt.isPresent()) throw new CustomException("Uma pessoa com o mesmo nome já existe", HttpStatus.BAD_REQUEST);

        Person createdPerson = personRepository.save(person);
        return PersonDTO.fromPerson(createdPerson);
    }

    @Override
    public Person updatePerson(Long id, Person updatedPerson) {
        return null;
    }

    @Override
    public void deletePerson(Long id) {

    }

    private Person getPersonByIdOrThrow(Long personId) {
        Optional<Person> personOpt = personRepository.findById(personId);
        return ServiceUtils.checkEntityExists(personOpt, "Pessoa não encontrada");
    }
}
