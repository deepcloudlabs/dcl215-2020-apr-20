package com.example.banking.service;

import com.example.banking.core.domain.Customer;
import com.example.banking.core.domain.TcKimlikNo;
import com.example.banking.core.repository.CustomerRepository;
import com.example.banking.repository.CustomerMongoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

// Hexagonal Architecture : Adapter -> SPI
@Service
public class CustomerService implements CustomerRepository {
    private CustomerMongoRepository repo;

    public CustomerService(CustomerMongoRepository repo) {
        this.repo = repo;
    }

    @Override
    public Optional<Customer> findCustomerByIdentity(TcKimlikNo identity) {
        return repo.findOneByIdentity(identity);
    }

    @Override
    public boolean saveCustomer(Customer cust) {
        repo.save(cust);
        return true;
    }
}
