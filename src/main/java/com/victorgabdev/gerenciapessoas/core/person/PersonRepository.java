package com.victorgabdev.gerenciapessoas.core.person;

import java.util.List;
import java.util.Optional;

public interface PersonRepository {
    List<Person> findAll();
    Optional<Person> findById(Long id);
    Person save(Person person);
    void deleteById(Long id);
    void setPrimaryAddress(Long personId, Long addressId);

}
