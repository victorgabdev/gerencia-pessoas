package com.victorgabdev.gerenciapessoas.modules.person.repository;

import com.victorgabdev.gerenciapessoas.core.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
