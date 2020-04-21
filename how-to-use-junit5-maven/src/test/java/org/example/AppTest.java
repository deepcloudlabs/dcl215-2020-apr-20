package org.example;

import org.example.tags.Functional;
import org.example.tags.Load;
import org.example.tags.Performance;
import org.example.tags.Stress;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
/*
pom.xml:
<plugin>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>2.22.1</version>
    <configuration>
         <excludedGroups>stress</excludedGroups>
    </configuration>
</plugin>
 */
public class AppTest {
    @Test
    @Functional
    void test1(){
        System.err.println("test 1");
    }

    @Test
    @Stress
    @Load
    @Tags({
       @Tag("stress"),
       @Tag("performance")
    })
    void test2(){
        System.err.println("test 2");
    }

    @Test
    @Performance
    void test3(){
        System.err.println("test 3");
    }
}
