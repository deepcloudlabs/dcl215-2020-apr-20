package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("tag examples #1")
public class UseTags {
    @Test
    @Tag("functional")
    void test1(){
        System.err.println("test 1");
    }

    @Test
    @Tag("stress")
    void test2(){
        System.err.println("test 2");
    }

    @Test
    @Tag("performance")
    void test3(){
        System.err.println("test 3");
    }
}
