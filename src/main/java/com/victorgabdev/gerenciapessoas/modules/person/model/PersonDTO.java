package com.victorgabdev.gerenciapessoas.modules.person.model;

import com.victorgabdev.gerenciapessoas.core.person.Person;

import java.util.Date;

public class PersonDTO {

    private String fullName;
    private Date birthDate;

    public PersonDTO() {
    }

    public PersonDTO(String fullName, Date birthDate) {
        this.fullName = fullName;
        this.birthDate = birthDate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public static PersonDTO fromPerson(Person person) {
        return new PersonDTO(person.getFullName(), person.getBirthDate());
    }
}
