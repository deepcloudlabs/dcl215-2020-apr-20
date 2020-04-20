package com.example;

import java.time.*;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyJavaSE8NewFeatures {

    public static void main(String[] args) {
        // x holds value : int
        int x = 42;
        // y holds reference -> object
        A y = new A();
        // z holds function
        // (1) anonymous class
        MyFunc z1 = new MyFunc() {
            @Override
            public int fn(int x) {
                return 3 * x + 2;
            }
        };
        // (2) Lambda Expression
        MyFunc z21 = (int r) -> {
            return 3 * r + 2;
        };
        MyFunc z22 = (r) -> {
            return 3 * r + 2;
        };
        MyFunc z23 = r -> {
            return 3 * r + 2;
        };
        MyFunc z24 = r -> 3 * r + 2;
        // (3) Method reference
        MyFunc z3 = BusinessService::run;
        // (3) -> (2) -> (1)
        // (2) Lambda Expression -> Function Object -> Anonymous Class

        List<Integer> numbers = List.of(4, 8, 15, 16, 23, 42);
        // even -> square -> sum
        // Build-in Functional Interfaces : Predicate, Function, Consumer, ...
        Predicate<Integer> evenNumber = i -> i % 2 == 0;
        ToIntFunction<Integer> square = i -> i * i;
        var sum = numbers.stream().filter(evenNumber).mapToInt(square).sum();

        // Java 8 : Date&Time API
        LocalDate localDate = LocalDate.of(1973, Month.JULY, 11);
        LocalTime localTime = LocalTime.of(10, 16);
        LocalDateTime birth = LocalDateTime.of(localDate, localTime);
        ZonedDateTime now = ZonedDateTime.now();
        Period period = Period.ofMonths(3); //  Date
        Duration duration; // Time
        localDate.minus(period);
        Instant t1 = Instant.now();
        // code runs....
        Instant t2 = Instant.now();
        System.out.println(Duration.between(t1, t2).toMillis());

        // Optional
        var fullname = A.findFullname();
        System.out.println(fullname.orElse("not available").length()); // NPE
    }
}

class A {
    public static Optional<String> findFullname() {
        return Optional.of("Jack Bauer");
    }
}
// Functional Programming
// Functional Interface

@FunctionalInterface
interface MyFunc { // function interface : SAM
    int fn(int x);
}

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
interface BusinessService {
    public static final double PI = 3.1415;

    void fun();

    int gun(int x);

    default String sun(String name) { // java 8
        return "Hello ".concat(name);
    }

    static int run(int i) {
        return 2 * i;
    } // java 8

    private int a(int j) {
        return j * j;
    } // java 9

    private static int b(int j) {
        return j * j * j;
    } // java 9
}