package com.example.banking.core.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@DisplayName("A customer")
public class CustomerTest {
    @Test
    @DisplayName("is created")
    void createCustomer() {
        assumeTrue(TcKimlikNo.validate("1"));
        Customer customer = new Customer(TcKimlikNo.of("1"), "Jack Bauer");
        assertAll(
                () -> assertEquals("1", customer.getIdentity().getValue()),
                () -> assertEquals("Jack Bauer", customer.getFullName()),
                () -> assertEquals(0, customer.getAccounts().size())
        );
    }

    @Nested
    @DisplayName("manages accounts")
    class AccountManagement {

        @Test
        @DisplayName("add one account to customer accounts")
        void addAccountToCustomer() {
            Customer customer = new Customer(TcKimlikNo.of("1"), "Jack Bauer");
            customer.addAccount(new Account("TR1", new Currency(1_000, CurrencyEnum.TL)));
            assertEquals(1,customer.getAccounts().size());
        }
    }
}
