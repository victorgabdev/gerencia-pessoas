package com.victorgabdev.gerenciapessoas.modules.address.service;

import com.victorgabdev.gerenciapessoas.core.address.Address;
import com.victorgabdev.gerenciapessoas.core.address.AddressService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    @Override
    public Optional<Address> getAddressById(Long id) {
        return Optional.empty();
    }

    @Override
    public Address createAddress(Address address) {
        return null;
    }

    @Override
    public Address updateAddress(Long id, Address updatedAddress) {
        return null;
    }

    @Override
    public void deleteAddress(Long id) {

    }
}
