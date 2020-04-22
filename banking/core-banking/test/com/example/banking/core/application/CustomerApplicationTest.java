package com.example.banking.core.application;

import com.example.banking.core.domain.Account;
import com.example.banking.core.domain.Currency;
import com.example.banking.core.domain.Customer;
import com.example.banking.core.domain.TcKimlikNo;
import com.example.banking.core.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static com.example.banking.core.domain.CurrencyEnum.TL;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerApplicationTest {
    @Test
    void createApplication() {
        InMemoryCustomerRepository repository = new InMemoryCustomerRepository();
        CustomerApplicationIncomingPort customerApplication = new CustomerApplication(repository);
        assertNotNull(customerApplication);
    }

    @Test
    void transferBetweenCustomerAccountsThenSuccessful() {
        // Setup
        TcKimlikNo identity = TcKimlikNo.of("1");
        Customer customer = new Customer(identity, "Jack Bauer");
        Account fromAccount = new Account("TR1", new Currency(2_000, TL));
        Account toAccount = new Account("TR2", new Currency(1_000, TL));
        customer.addAccount(fromAccount);
        customer.addAccount(toAccount);
        // Test Doubles
         // Dummy Object
        /*
        var repository = new CustomerRepository(){
            @Override
            public Optional<Customer> findCustomerByIdentity(TcKimlikNo identity) {
                return Optional.empty();
            }
        };
        /*
// Fake Object Usage
        InMemoryCustomerRepository repository = new InMemoryCustomerRepository();
        repository.addCustomer(customer);
         */
        // Mock Object
        CustomerRepository repository = Mockito.mock(CustomerRepository.class);
        Mockito.when(repository.findCustomerByIdentity(identity)).thenReturn(Optional.ofNullable(customer));
        Mockito.when(repository.saveCustomer(customer)).thenReturn(true);
        // Instrumentation API -> CG Library
        System.err.println(repository.getClass());
        CustomerApplicationIncomingPort customerApplication = new CustomerApplication(repository);

        // exercise method
        boolean success = customerApplication.transferBetweenAccounts(TcKimlikNo.of("1"), "TR1", "TR2",
                new Currency(1_000, TL));
        // verification
        assertAll(
                () -> assertTrue(success),
                () -> assertEquals(new Currency(1_000, TL), fromAccount.getBalance()),
                () -> assertEquals(new Currency(2_000, TL), toAccount.getBalance())
        );
    }
}
