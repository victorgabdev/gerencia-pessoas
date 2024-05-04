package com.victorgabdev.gerenciapessoas.core.address;

import java.util.Optional;

public interface AddressService {
    Optional<Address> getAddressById(Long id);
    Address createAddress(Address address);
    Address updateAddress(Long id, Address updatedAddress);
    void deleteAddress(Long id);
}
