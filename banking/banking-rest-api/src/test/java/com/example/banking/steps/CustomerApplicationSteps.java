package com.example.banking.steps;

import com.example.banking.core.application.CustomerApplication;
import com.example.banking.core.domain.*;
import com.example.banking.core.repository.CustomerRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class CustomerApplicationSteps {
    private CustomerApplication customerApplication;
    private CustomerRepository customerRepository;
    private Customer customer;

    public CustomerApplicationSteps() {
        customerRepository = Mockito.mock(CustomerRepository.class);
        customerApplication = new CustomerApplication(customerRepository);
    }

    @Given("^a customer '(.*)' with identity (.*)$")
    public void aCustomerJack(String fullname, String identity) {
        customer = new Customer(TcKimlikNo.of(identity), fullname);
    }

    @Given("^account (.*) with (.*) TL$")
    public void withAccount(String iban, double amount) {
        customer.addAccount(new Account(Iban.of(iban), new Currency(amount, CurrencyEnum.TL)));
    }

    @When("^the customer transfers (.*) TL from account (.*) to account (.*)$")
    public void theCustomerTransfersTLFromTRToTR(double amount, String fromIban, String toIban) {
        Mockito.when(customerRepository.findCustomerByIdentity(customer.getIdentity())).thenReturn(Optional.of(customer));
        customerApplication.transferBetweenAccounts(customer.getIdentity(), fromIban, toIban, new Currency(amount, CurrencyEnum.TL));
    }

    @Then("^There is (.*) TL in account (.*) and (.*) TL in account (.*)$")
    public void thenHappens(double fromMoney, String fromIban, double toMoney, String toIban) {
        assertAll(
                () -> assertEquals(new Account(Iban.of(fromIban), new Currency(fromMoney, CurrencyEnum.TL)), customer.findAccountByIban(Iban.of(fromIban)).get()),
                () -> assertEquals(new Account(Iban.of(toIban), new Currency(toMoney, CurrencyEnum.TL)), customer.findAccountByIban(Iban.of(toIban)).get())
        );
    }
}
