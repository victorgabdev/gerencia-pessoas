package com.victorgabdev.gerenciapessoas.core.address;

import java.util.List;
import java.util.Optional;

public interface AddressRepository {
    List<Address> findAll();
    Optional<Address> findById(int id);
    Address save(Address address);
    void delete(Address address);
}
