package com.example.banking.core.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
// Event Storming -> Domain, Ubiquties Language, Bounded Context, Aggregate

// Aggregate -> Root Entity -> Identity
//              Invariance -> Validation, Consistency
public class Customer { // Bounded Context
    private final TcKimlikNo identity; // tc kimlik no
    private final String fullName;
    private Map<String, Account> accounts = new HashMap<>();

    public Customer(TcKimlikNo identity, String fullName) {
        this.identity = identity;
        this.fullName = fullName;
    }

    public TcKimlikNo getIdentity() {
        return identity;
    }

    public String getFullName() {
        return fullName;
    }

    public List<Object> getAccounts() {
        return accounts.values().stream().collect(Collectors.toList());
    }

    public void addAccount(Account account) {
        accounts.put(account.getIban(), account);
    }

    public Optional<Account> findAccountByIban(String iban) {
        return Optional.ofNullable(accounts.get(iban));
    }
}
