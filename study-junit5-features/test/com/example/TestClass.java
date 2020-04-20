package com.example;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class TestClass {
    @Test
    public void testSum() {
        // setup/fixture
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        // call exercise method(s)
        var sum = numbers.stream()
                .filter(i -> i % 2 == 1)
                .mapToInt(x -> x * x)
                .sum();
        // verify
        assertEquals(35, sum);
        // teardown
        // empty
    }
}
