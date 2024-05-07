package com.victorgabdev.gerenciapessoas.modules.person.repository;

import com.victorgabdev.gerenciapessoas.core.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByFullName(String fullName);
}
