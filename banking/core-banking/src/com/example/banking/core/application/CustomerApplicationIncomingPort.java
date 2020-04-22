package com.example.banking.core.application;

import com.example.banking.core.domain.Currency;
import com.example.banking.core.domain.TcKimlikNo;

// API
public interface CustomerApplicationIncomingPort {

    boolean transferBetweenAccounts(TcKimlikNo identity, String fromIban, String toIban, Currency currency);
}
