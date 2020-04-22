package com.example.banking.repository;

import com.example.banking.core.domain.Customer;
import com.example.banking.core.domain.TcKimlikNo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerMongoRepository extends MongoRepository<Customer, TcKimlikNo> {
    Optional<Customer> findOneByIdentity(TcKimlikNo identity);
}
