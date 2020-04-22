package com.example.banking.request;

public class TransferRequest {
    private String identity;
    private String fromIban;
    private String toIban;
    private double amount;

    public TransferRequest() {
    }

    public TransferRequest(String identity, String fromIban, String toIban, double amount) {
        this.identity = identity;
        this.fromIban = fromIban;
        this.toIban = toIban;
        this.amount = amount;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getFromIban() {
        return fromIban;
    }

    public void setFromIban(String fromIban) {
        this.fromIban = fromIban;
    }

    public String getToIban() {
        return toIban;
    }

    public void setToIban(String toIban) {
        this.toIban = toIban;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
