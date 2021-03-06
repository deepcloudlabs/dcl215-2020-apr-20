package com.example.banking.core.application;

import com.example.banking.core.domain.*;
import com.example.banking.core.repository.CustomerRepository;

import java.util.Optional;

public class CustomerApplication implements CustomerApplicationIncomingPort {
    private CustomerRepository customerRepository;

    public CustomerApplication(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // user story
    @Override
    public boolean transferBetweenAccounts(TcKimlikNo identity, String fromIban, String toIban, Currency currency) {
        Optional<Customer> customer = customerRepository.findCustomerByIdentity(identity);
        if(customer.isPresent()){
            var cust = customer.get();
            var fromAccount = cust.findAccountByIban(Iban.of(fromIban));
            var toAccount = cust.findAccountByIban(Iban.of(toIban));
            if (fromAccount.isPresent() && toAccount.isPresent()){
                try {
                    fromAccount.get().withdraw(currency);
                    toAccount.get().deposit(currency);
                    customerRepository.saveCustomer(cust);
                    return true;
                } catch (InsufficientBalanceException e) {
                    e.printStackTrace();
                }
            }
            return false;
        }
        return false;
    }
}
