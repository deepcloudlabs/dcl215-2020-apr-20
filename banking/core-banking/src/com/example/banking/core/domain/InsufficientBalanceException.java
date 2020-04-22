package com.example.banking.core.domain;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class InsufficientBalanceException extends Exception {
    private final double deficit;

    public InsufficientBalanceException(String message, double deficit) {
        super(message);
        this.deficit = deficit;
    }

    public double getDeficit() {
        return deficit;
    }
}
