package com.example;

import org.junit.jupiter.api.Test;

import java.time.ZoneId;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class UseAssume {
    @Test // static test
    void test1(){
        // Java 8 : Date/Time API
        assumeTrue(ZoneId.systemDefault().getId().contains("Asia"));
        System.err.println("test1");
    }

    @Test // static test
    void test2(){
        assumeTrue(ZoneId.systemDefault().getId().contains("Africa"));
        System.err.println("test2");
    }
}
