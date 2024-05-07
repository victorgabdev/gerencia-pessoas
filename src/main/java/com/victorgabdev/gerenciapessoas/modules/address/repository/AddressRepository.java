package com.victorgabdev.gerenciapessoas.modules.address.repository;
import com.victorgabdev.gerenciapessoas.core.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface AddressRepository extends JpaRepository<Address, Long> {
    Optional<Address> findByIdAndPersonId(Long id, Long personId);
}
