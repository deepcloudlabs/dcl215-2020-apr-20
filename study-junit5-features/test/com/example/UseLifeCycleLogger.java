package com.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public interface UseLifeCycleLogger {
    @BeforeAll
    static void beforeAllTests() {
        System.out.println("@BeforeAll runs once before all test methods...");
    }

    @AfterAll
    static void afterAllTests() {
        System.out.println("@AfterAll runs once after all test methods...");
    }

    @BeforeEach
    default void beforeEachTest() {
        System.out.println("@BeforeEach runs once before each test method...");
    }

    @AfterEach
    default void afterEachTest() {
        System.out.println("@AfterEach runs once after each test method...");
    }
}
