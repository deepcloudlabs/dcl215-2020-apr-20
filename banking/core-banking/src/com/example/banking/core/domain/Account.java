package com.example.banking.core.domain;

// entity -> identity -> iban
public class Account {
    private final String iban;
    private Currency balance; // value object

    public Account(String iban, Currency balance) {
        this.iban = iban;
        this.balance = balance ;
    }

    public String getIban() {
        return iban;
    }

    public Currency getBalance() {
        return balance;
    }

    public void deposit(Currency currency) {
        if (currency.currency()!=this.balance.currency())
            throw new IllegalArgumentException("Currency should be equal!");
        if (currency.amount()<=0.)
            throw new IllegalArgumentException("Currency amount must be positive!");
        this.balance = new Currency(
                 this.balance.amount()+currency.amount(),
                this.balance.currency());
    }

    public void withdraw(Currency currency) throws InsufficientBalanceException {
        if (currency.currency()!=this.balance.currency())
            throw new IllegalArgumentException("Currency should be equal!");
        if (currency.amount()<=0.)
            throw new IllegalArgumentException("Currency amount must be positive!");
        if (currency.amount()>this.balance.amount())
            throw new InsufficientBalanceException();
        this.balance = new Currency(this.balance.amount()-currency.amount(),
                   this.balance.currency());
    }
}
