package com.example.trainingproject.Repository;

import com.example.trainingproject.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
