package com.victorgabdev.gerenciapessoas.core.address;

import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    Optional<Address> getAddressToPerson(Long personId);
    List<Address> getAllAddressToPerson(Long personId);
    Address createAddressToPerson(Long personId, Address address);
    Address updateAddressToPerson(Long personId ,Long addressId, Address updatedAddress);
    void deleteAddressToPerson(Long personId ,Long addressId);
}
