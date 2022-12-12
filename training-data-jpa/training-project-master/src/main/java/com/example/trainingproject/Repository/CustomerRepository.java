package com.example.trainingproject.Repository;

import com.example.trainingproject.model.Account;
import com.example.trainingproject.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Optional<Customer> findByFullName(String fullName);
}
