package com.example.banking.response;

public class TransferResponse {
    private final String status;

    public TransferResponse(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
