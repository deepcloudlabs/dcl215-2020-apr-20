package com.example.banking;


import com.example.banking.core.domain.*;
import com.example.banking.service.CustomerService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
@DisplayName("Persistence Adapter Test")
// @RunWith(SpringRunner.class) // JUnit 4
@BootstrapWith(SpringBootTestContextBootstrapper.class)
@ExtendWith({SpringExtension.class})
public class CustomerRepositoryTest {
    @Autowired // CUT
    CustomerService customerSrv;
    @Autowired
    MongoTemplate mongoTemplate;

    @BeforeEach
    void createTestCustomer() {
        Customer customer = new Customer(TcKimlikNo.of("1"), "Jack Bauer");
        customer.addAccount(new Account("TR1", new Currency(1_000, CurrencyEnum.TL)));
        mongoTemplate.save(customer);
    }

    @Test
    void findCustomerByIdentityShouldReturnOne() {
        // exercise
        TcKimlikNo identity = TcKimlikNo.of("1");
        var customer = customerSrv.findCustomerByIdentity(identity);
        // verification
        assertAll(
                () -> assertTrue(customer.isPresent()),
                () -> assertEquals(identity, customer.get().getIdentity())
        );
    }

    @Test
    void findCustomerByIdentityShouldReturnEmpty() {
        // exercise
        TcKimlikNo identity = TcKimlikNo.of("2");
        var customer = customerSrv.findCustomerByIdentity(identity);
        // verification
        assertFalse(customer.isPresent());
    }

    @AfterEach
    void dropCustomerCollection() {
        mongoTemplate.dropCollection(Customer.class);
    }
}
