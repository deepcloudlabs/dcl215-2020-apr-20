package com.example.domain;

// CUT : Class Under Test
// White-box Testing
public class Customer {
    private final String identity;
    private final String fullname;

    public Customer(String identity, String fullname) {
        this.identity = identity;
        this.fullname = fullname;
    }

    public String getIdentity() {
        return identity;
    }

    public String getFullname() {
        return fullname;
    }
}
