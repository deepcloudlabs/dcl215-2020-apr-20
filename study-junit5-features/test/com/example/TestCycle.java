package com.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class TestCycle {
    @BeforeAll
    static void setup() {
        System.out.println("@BeforeAll runs once before all test methods...");
    }

    @BeforeEach
    void init() {
        System.out.println("@BeforeEach runs once before each test method...");
    }

    @Test
    public void test1() throws Throwable {
        System.out.println("test1()");
    }

    @Test
    public void test2() throws Throwable {
        System.out.println("test2()");
    }
}
