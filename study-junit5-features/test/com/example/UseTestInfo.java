package com.example;

import org.junit.jupiter.api.*;

@DisplayName("test info exercise")
public class UseTestInfo {
    @Test
    @DisplayName("case 1")
    @Tags({
            @Tag("tag 1"),
            @Tag("tag 2")
    })
    void test1(TestInfo info) {
        System.out.println(info.getDisplayName());
        System.out.println(info.getTestClass()); // CUT
        System.out.println(info.getTestMethod()); // MUT
        System.out.println(info.getTags()); // Tags?
    }

    @Test
    @DisplayName("case 2")
    void test2(TestInfo info) {
        System.out.println(info.getDisplayName());
        System.out.println(info.getTestClass()); // CUT
        System.out.println(info.getTestMethod()); // MUT
        System.out.println(info.getTags()); // Tags
    }
}
