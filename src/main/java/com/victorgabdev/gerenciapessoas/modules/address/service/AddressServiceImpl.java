package com.victorgabdev.gerenciapessoas.modules.address.service;

import com.victorgabdev.gerenciapessoas.core.address.Address;
import com.victorgabdev.gerenciapessoas.core.address.AddressRepository;
import com.victorgabdev.gerenciapessoas.core.address.AddressService;
import com.victorgabdev.gerenciapessoas.core.person.Person;
import com.victorgabdev.gerenciapessoas.core.person.PersonRepository;
import com.victorgabdev.gerenciapessoas.core.person.PersonService;
import com.victorgabdev.gerenciapessoas.shared.exceptions.CustomException;
import com.victorgabdev.gerenciapessoas.util.ServiceUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    private final PersonService personService;
    private final PersonRepository personRepository;

    public AddressServiceImpl(AddressRepository addressRepository, PersonService personService, PersonRepository personRepository) {
        this.addressRepository = addressRepository;
        this.personService = personService;
        this.personRepository = personRepository;
    }


    @Override
    public Address getAddressToPerson(Long personId, Long addressId) {
        Person person =  getPersonByIdOrThrow(personId);
        Address address = addressRepository.findByIdAndPersonId(addressId, personId)
                .orElseThrow(() -> new CustomException("Endereço não encontrado para a pessoa especificada", HttpStatus.NOT_FOUND));
        return address;
    }


    @Override
    public List<Address> getAllAddressToPerson(Long personId) {
        Person person = getPersonByIdOrThrow(personId);
        return person.getAddresses();
    }

    @Override
    public Address createAddressToPerson(Long personId, Address address) {
        Person person = getPersonByIdOrThrow(personId);
        if (address.isPrimary()) person.getAddresses().forEach(ad -> ad.setPrimary(false));
        person.getAddresses().add(address);

        personRepository.save(person);
        addressRepository.save(address);

        return address;
    }

    @Override
    public Address updateAddressToPerson(Long personId, Long addressId, Address updatedAddress) {
        return null;
    }

    @Override
    public void deleteAddressToPerson(Long personId, Long addressId) {

    }

    private Person getPersonByIdOrThrow(Long personId) {
        Optional<Person> personOpt = personRepository.findById(personId);
        return ServiceUtils.checkEntityExists(personOpt, "Pessoa não encontrada");
    }
}
