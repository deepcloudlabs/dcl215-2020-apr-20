package com.example.banking.core.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
@DisplayName("An account")
public class AccountTest {

    @ParameterizedTest
    @EnumSource(CurrencyEnum.class)
    void createAccount(CurrencyEnum currencyEnum) {
        Account acc = new Account("TR1", new Currency(1_000, currencyEnum));
        assertAll(
                () -> assertEquals("TR1", acc.getIban()),
                () -> assertEquals(new Currency(1_000, currencyEnum), acc.getBalance())
        );
    }

    @Nested
    @DisplayName("deposit")
    class Deposit {
        @Test
        @DisplayName("with positive amount should return success")
        void depositPositiveAmountThenReturnSuccess() {
            Account acc = new Account("TR1", new Currency(1_000, CurrencyEnum.TL));
            acc.deposit(new Currency(1, CurrencyEnum.TL));
            assertEquals(new Currency(1_001, CurrencyEnum.TL), acc.getBalance());
        }

        @Test
        @DisplayName("with different currency then throw IllegalArgumentException")
        void depositDifferentCurrencyThenThrowIllegalArgumentException() throws Throwable {
            Account acc = new Account("TR1", new Currency(1_000, CurrencyEnum.TL));
            assertAll(
                    () -> assertThrows(IllegalArgumentException.class, () -> acc.deposit(new Currency(1, CurrencyEnum.EUR))),
                    () -> assertEquals(new Currency(1_000, CurrencyEnum.TL), acc.getBalance())
            );
        }

        @Test
        @DisplayName("with negative amount then throw IllegalArgumentException")
        void depositWithNegativeAmountThenThrowIllegalArgumentException() throws Throwable {
            Account acc = new Account("TR1", new Currency(1_000, CurrencyEnum.TL));
            assertAll(
                    () -> assertThrows(IllegalArgumentException.class, () -> acc.deposit(new Currency(-1, CurrencyEnum.TL))),
                    () -> assertEquals(new Currency(1_000, CurrencyEnum.TL), acc.getBalance())
            );
        }

    }

    @Nested
    @DisplayName("withdraw")
    class Withdraw {
        @Test
        @DisplayName("with over balance should throw InsufficientBalanceException")
        void withdrawOverBalanceShouldThrowInsufficientBalanceException() {
            Account acc = new Account("TR1", new Currency(1_000, CurrencyEnum.TL));
            assertAll(
                    () -> assertThrows(InsufficientBalanceException.class, () -> acc.withdraw(new Currency(1_001, CurrencyEnum.TL))),
                    () -> assertEquals(new Currency(1_000, CurrencyEnum.TL), acc.getBalance())
            );
        }

        @Test
        @DisplayName("all balance should be successful")
        void withdrawAllBalanceShouldBeOk() throws Throwable {
            Account acc = new Account("TR1", new Currency(1_000, CurrencyEnum.TL));
            acc.withdraw(new Currency(1_000, CurrencyEnum.TL));
            assertEquals(new Currency(0, CurrencyEnum.TL), acc.getBalance());
        }

        @Test
        @DisplayName("with different currency then throw IllegalArgumentException")
        void withdrawDifferentCurrencyThenThrowIllegalArgumentException() throws Throwable {
            Account acc = new Account("TR1", new Currency(1_000, CurrencyEnum.TL));
            assertAll(
                    () -> assertThrows(IllegalArgumentException.class, () -> acc.withdraw(new Currency(1, CurrencyEnum.EUR))),
                    () -> assertEquals(new Currency(1_000, CurrencyEnum.TL), acc.getBalance())
            );
        }

        @Test
        @DisplayName("with negative amount then throw IllegalArgumentException")
        void withdrawWithNegativeAmountThenThrowIllegalArgumentException() throws Throwable {
            Account acc = new Account("TR1", new Currency(1_000, CurrencyEnum.TL));
            assertAll(
                    () -> assertThrows(IllegalArgumentException.class, () -> acc.withdraw(new Currency(-1, CurrencyEnum.TL))),
                    () -> assertEquals(new Currency(1_000, CurrencyEnum.TL), acc.getBalance())
            );
        }

    }
}
