package com.example;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class UseTimeOut {

    @Test
    //@Timeout(5) 5 seconds
    void test1() throws InterruptedException {
        TimeUnit.HOURS.sleep(1);
    }
}
