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
    private final PersonRepository personRepository;

    public AddressServiceImpl(AddressRepository addressRepository, PersonService personService, PersonRepository personRepository) {
        this.addressRepository = addressRepository;
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
        Person person = getPersonByIdOrThrow(personId);
        Address addressToUpdate = getAddressByIdOrThrow(person, addressId);

        addressToUpdate.setStreet(updatedAddress.getStreet());
        addressToUpdate.setZipCode(updatedAddress.getZipCode());
        addressToUpdate.setNumber(updatedAddress.getNumber());
        addressToUpdate.setCity(updatedAddress.getCity());
        addressToUpdate.setState(updatedAddress.getState());
        addressToUpdate.setPrimary(updatedAddress.isPrimary());

        return addressRepository.save(addressToUpdate);
    }

    @Override
    public void deleteAddressToPerson(Long personId, Long addressId) {
        Person person = getPersonByIdOrThrow(personId);
        Address addressToDelete = getAddressByIdOrThrow(person, addressId);

        person.getAddresses().remove(addressToDelete);
        addressRepository.delete(addressToDelete);
    }

    private Person getPersonByIdOrThrow(Long personId) {
        Optional<Person> personOpt = personRepository.findById(personId);
        return ServiceUtils.checkEntityExists(personOpt, "Pessoa não encontrada");
    }

    private Address getAddressByIdOrThrow(Person person, Long addressId) {
        return person.getAddresses().stream()
                .filter(address -> address.getId().equals(addressId))
                .findFirst()
                .orElseThrow(() -> new CustomException("Endereço não encontrado para a pessoa especificada", HttpStatus.NOT_FOUND));
    }
}
