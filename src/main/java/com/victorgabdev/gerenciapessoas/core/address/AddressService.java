package com.victorgabdev.gerenciapessoas.core.address;

import java.util.List;

public interface AddressService {
    Address getAddressToPerson(Long personId, Long addressId);
    List<Address> getAllAddressToPerson(Long personId);
    Address createAddressToPerson(Long personId, Address address);
    Address updateAddressToPerson(Long personId ,Long addressId, Address updatedAddress);
    void deleteAddressToPerson(Long personId ,Long addressId);
}
