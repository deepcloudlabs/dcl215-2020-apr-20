package com.example;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UseDynamicTest {

    @TestFactory // dynamic test
    Collection<DynamicTest> test1(){
        return List.of(
             DynamicTest.dynamicTest(
                     "my test #1" ,
                     () -> {
                         // setup
                         // call exercise method
                         // verify
                     }
             ),
             DynamicTest.dynamicTest(
                     "my test #2" ,
                     () -> assertEquals(9, 3 *3)
             ),             DynamicTest.dynamicTest(
                     "my test #3" ,
                     () -> assertEquals(4, 2 + 2)
             )
        );
    }
    // Collection<DynamicTest>
    // Iterator<DynamicTest>
    // Iterable<DynamicTest>
    // Stream<DynamicTest> : Stream API -> FilterMapReduce
    @TestFactory
    Stream<DynamicTest> test2() {
        return IntStream.range(0,10)
                 .mapToObj( i -> DynamicTest.dynamicTest(
                    "test #"+ i, () -> {}
                 ));
    }

    @TestFactory
    Collection<DynamicTest> test3() {
        List<DynamicTest> tests = new ArrayList<>();
        for (int i=0;i<10;++i)
            tests.add(DynamicTest.dynamicTest(
                    "test #"+ i, () -> { /* use i */}
                 ));
        return tests;
    }
}
