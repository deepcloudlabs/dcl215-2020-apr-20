package com.example.banking.core.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
@DisplayName("A customer")
public class CustomerTest {
    @Test
    @DisplayName("is created")
    void createCustomer() {
        assumeTrue(TcKimlikNo.validate("41541519156"));
        Customer customer = new Customer(TcKimlikNo.of("41541519156"), "Jack Bauer");
        assertAll(
                () -> assertEquals("41541519156", customer.getIdentity().getValue()),
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
            Customer customer = new Customer(TcKimlikNo.of("41541519156"), "Jack Bauer");
            customer.addAccount(new Account(Iban.of("TR860006255387165769721543"), new Currency(1_000, CurrencyEnum.TL)));
            assertEquals(1, customer.getAccounts().size());
        }

        @Test
        @DisplayName("find one account by iban")
        void findAccountByIbanShoudlReturnSuccess() {
            var customer = new Customer(TcKimlikNo.of("41541519156"), "Jack Bauer");
            customer.addAccount(new Account(Iban.of("TR860006255387165769721543"), new Currency(1_000, CurrencyEnum.TL)));
            assertEquals(1, customer.getAccounts().size());
            var account = customer.findAccountByIban(Iban.of("TR860006255387165769721543"));
            assertTrue(account.isPresent());
            assertEquals(new Account(Iban.of("TR860006255387165769721543"), new Currency(1_000, CurrencyEnum.TL)), account.get());
        }
    }
}
