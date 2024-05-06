package com.victorgabdev.gerenciapessoas.modules.address.controller;

import com.victorgabdev.gerenciapessoas.core.address.Address;
import com.victorgabdev.gerenciapessoas.core.address.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/addresses")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("person/{personId}")
    public ResponseEntity<List<Address>> getAllAddressesByPersonId(@PathVariable Long personId) {
        List<Address> addresses = addressService.getAllAddressToPerson(personId);
        return ResponseEntity.ok(addresses);
    }

    @GetMapping("person/{personId}/{addressId}")
    public ResponseEntity<Address> getAddressByPersonIdAndAddressId(@PathVariable Long personId, @PathVariable Long addressId) {
        Address address = addressService.getAddressToPerson(personId, addressId);
        return ResponseEntity.ok(address);
    }

    // @PostMapping

    // @PutMapping

    // @DeleteMapping

}
