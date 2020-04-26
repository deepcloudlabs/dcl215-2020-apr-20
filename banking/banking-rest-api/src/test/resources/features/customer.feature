Feature: Customers can transfer money between accounts

  Scenario: Customer can transfer money between his/her accounts
    Given a customer 'Jack Bauer' with identity 79993969472
    And account TR380006274316324581799268 with 2000.0 TL
    And account TR190006274224756217151196 with 5000.0 TL
    When the customer transfers 1000.0 TL from account TR380006274316324581799268 to account TR190006274224756217151196
    Then There is 1000.0 TL in account TR380006274316324581799268 and 6000.0 TL in account TR190006274224756217151196