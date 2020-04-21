package com.example;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

public class UseRepeatedTest {

    @RepeatedTest(5)
    void test1(RepetitionInfo info){ // Dependency Injection
        System.err.println(String.format("#%d of %d",
                info.getCurrentRepetition(),
                info.getTotalRepetitions()));
    }
}
