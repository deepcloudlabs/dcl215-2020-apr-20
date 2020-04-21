package com.example;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
// Default : dictionary order
// @Order
// Random
@TestMethodOrder(MethodOrderer.Random.class)
public class UseTestOrder {
    @Test
    @Order(3)
    void test1() {
        /*
        for (Method method : UseTestOrder.class.getDeclaredMethods())
            System.err.println(method.getName());
         */
        System.err.println("test 1");
    }

    @Test
    @Order(1)
    void test3() {
        System.err.println("test 3");
    }

    @Test
    @Order(2)
    void test2() {
        System.err.println("test 2");
    }

}
