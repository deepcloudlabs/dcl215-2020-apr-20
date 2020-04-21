package com.example;

import com.example.condition.ConditionalOnOperatingSystem;
import com.example.condition.OperatingSystem;
import org.junit.jupiter.api.Test;

public class UseConditionalTest {
    @Test
    @ConditionalOnOperatingSystem(OperatingSystem.WINDOWS)
    void test1(){
        System.out.println("Running on windows...");
    }

    @Test
    @ConditionalOnOperatingSystem(OperatingSystem.LINUX)
    void test2(){
        System.out.println("Running on linux...");
    }

    @Test
    @ConditionalOnOperatingSystem({OperatingSystem.WINDOWS,OperatingSystem.LINUX})
    void test3(){
        System.err.println("Running test3...");
    }
}
