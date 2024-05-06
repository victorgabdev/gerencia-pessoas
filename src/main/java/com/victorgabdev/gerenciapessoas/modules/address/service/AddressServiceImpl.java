package com.victorgabdev.gerenciapessoas.modules.address.service;

import com.victorgabdev.gerenciapessoas.core.address.Address;
import com.victorgabdev.gerenciapessoas.core.address.AddressRepository;
import com.victorgabdev.gerenciapessoas.core.address.AddressService;
import com.victorgabdev.gerenciapessoas.core.person.Person;
import com.victorgabdev.gerenciapessoas.core.person.PersonRepository;
import com.victorgabdev.gerenciapessoas.core.person.PersonService;
import com.victorgabdev.gerenciapessoas.shared.exceptions.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    private final PersonService personService;

    public AddressServiceImpl(AddressRepository addressRepository, PersonRepository personRepository, PersonService personService) {
        this.addressRepository = addressRepository;
        this.personService = personService;
    }


    @Override
    public Address getAddressToPerson(Long personId, Long addressId) {
        Person person = personService.getPersonById(personId);
        Optional<Address> addressOpt = addressRepository.findById(addressId);
        if (!addressOpt.isPresent()) throw new CustomException("Endereço não existe", HttpStatus.NOT_FOUND);

        Address addressToFind = addressOpt.get();
        return person.getAddresses()
                .stream()
                .filter(address -> address.getId().equals(addressToFind.getId()))
                .findFirst()
                .orElseThrow(() -> new CustomException("Endereço não encontrado para a pessoa especificada", HttpStatus.NOT_FOUND));
    }


    @Override
    public List<Address> getAllAddressToPerson(Long personId) {
        Person person = personService.getPersonById(personId);
        List<Address> addressesToPerson = person.getAddresses();
        if(addressesToPerson.isEmpty()) throw new CustomException("A Pessoa não possui endereço cadastrado", HttpStatus.NOT_FOUND);

        return addressesToPerson;
    }

    @Override
    public Address createAddressToPerson(Long personId, Address address) {
        return null;
    }

    @Override
    public Address updateAddressToPerson(Long personId, Long addressId, Address updatedAddress) {
        return null;
    }

    @Override
    public void deleteAddressToPerson(Long personId, Long addressId) {

    }
}
