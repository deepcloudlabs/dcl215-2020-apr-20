package com.example.banking.core.domain;

import java.util.Objects;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
// entity -> identity -> iban
public class Account {
    private final Iban iban;
    private Currency balance; // value object

    public Account(Iban iban, Currency balance) {
        this.iban = iban;
        this.balance = balance;
    }

    public Iban getIban() {
        return iban;
    }

    public Currency getBalance() {
        return balance;
    }

    public void deposit(Currency money) {
        if (money.currency() != this.balance.currency())
            throw new IllegalArgumentException("Currency should be equal!");
        if (money.amount() <= 0.)
            throw new IllegalArgumentException("Currency amount must be positive!");
        this.balance = this.balance.plus(money);
    }

    public void withdraw(Currency money) throws InsufficientBalanceException {
        if (money.currency() != this.balance.currency())
            throw new IllegalArgumentException("Currency should be equal!");
        if (money.amount() <= 0.)
            throw new IllegalArgumentException("Currency amount must be positive!");
        if (money.amount() > this.balance.amount())
            throw new InsufficientBalanceException("Your balance does not cover your expenses", balance.amount() - money.amount());
        this.balance = this.balance.minus(money);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        return Objects.equals(iban, account.iban);
    }

    @Override
    public int hashCode() {
        return iban != null ? iban.hashCode() : 0;
    }
}
