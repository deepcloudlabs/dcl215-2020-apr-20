package com.example.banking.core.repository;

import com.example.banking.core.domain.Customer;
import com.example.banking.core.domain.TcKimlikNo;

import java.util.Optional;

// SPI : Service Provider Interface
public interface CustomerRepository {
    Optional<Customer> findCustomerByIdentity(TcKimlikNo identity);

    default boolean saveCustomer(Customer cust){ return true;}
}
