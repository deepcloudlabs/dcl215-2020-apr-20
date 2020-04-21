package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;

public class UseCsvFileTest {


    @ParameterizedTest
    @CsvFileSource(resources = "/area-codes.csv")
    void test1(String city,int code){
        System.err.println(String.format("%s: %d",city,code));
    }

    @ParameterizedTest
    @CsvSource({
        "ankara,312",
        "istanbul-anadolu,216",
        "istanbul-avrupa,212"
    })
    void test2(String city,int code){
        System.err.println(String.format("%s: %d",city,code));
    }

    @ParameterizedTest
    @MethodSource("generateNumbers")
    void test3(int number){
        System.err.println(number);
    }

    @ParameterizedTest
    @ValueSource(ints={1,2,3,4,5,6,7,8,9})
    void test4(int number){
        System.err.println(number);
    }

    @ParameterizedTest
    @ValueSource(strings={"jack","kate","james","ben","hugo"})
//    @NullSource
//    @EmptySource
    @NullAndEmptySource
    void test5(String name){
        System.err.println("name: "+name);
    }

    static List<Integer> generateNumbers() {
        return List.of(1,2,3,4,5,6,7,8,9);
    }
}
