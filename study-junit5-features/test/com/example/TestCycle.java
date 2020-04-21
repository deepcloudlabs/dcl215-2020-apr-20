package com.example;

import org.junit.jupiter.api.Test;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class TestCycle implements UseLifeCycleLogger {

    @Test
    public void test1() throws Throwable {
        System.out.println("test1()");
    }

    @Test
    public void test2() throws Throwable {
        System.out.println("test2()");
    }
}
