package com.example.banking.core.application;

import com.example.banking.core.domain.Customer;
import com.example.banking.core.domain.TcKimlikNo;
import com.example.banking.core.repository.CustomerRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
// Fake Object
public class InMemoryCustomerRepository implements CustomerRepository {
    private Map<TcKimlikNo,Customer> customers = new HashMap<>();

    public InMemoryCustomerRepository() {
    }

    @Override
    public Optional<Customer> findCustomerByIdentity(TcKimlikNo identity) {
        return Optional.ofNullable(customers.get(identity));
    }

    public void addCustomer(Customer customer){
        customers.put(customer.getIdentity(),customer);
    }
}
