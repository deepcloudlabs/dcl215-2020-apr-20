package com.example.banking.core.application;

import com.example.banking.core.domain.*;
import org.junit.jupiter.api.Test;

import static com.example.banking.core.domain.CurrencyEnum.*;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerApplicationTest {
    @Test
    void createApplication(){
        InMemoryCustomerRepository repository = new InMemoryCustomerRepository();
        CustomerApplication customerApplication = new CustomerApplication(repository);
        assertNotNull(customerApplication);
    }

    @Test
    void transferBetweenCustomerAccountsThenSuccessful(){
        // Setup
        InMemoryCustomerRepository repository = new InMemoryCustomerRepository();
        Customer customer = new Customer(TcKimlikNo.of("1"), "Jack Bauer");
        Account fromAccount = new Account("TR1", new Currency(2_000, TL));
        Account toAccount = new Account("TR2", new Currency(1_000, TL));
        customer.addAccount(fromAccount);
        customer.addAccount(toAccount);
        repository.addCustomer(customer);
        CustomerApplication customerApplication = new CustomerApplication(repository);

        // exercise method
        boolean success = customerApplication.transferBetweenAccounts(TcKimlikNo.of("1"),"TR1","TR2",
                new Currency(1_000, TL));
        // verification
        assertAll(
                () -> assertTrue(success),
                () -> assertEquals(new Currency(1_000, TL),fromAccount.getBalance()),
                () -> assertEquals(new Currency(2_000, TL),toAccount.getBalance())
        );
    }
}
