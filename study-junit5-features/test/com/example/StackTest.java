package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
@DisplayName("A Stack")
public class StackTest {

    @Test
    @DisplayName("is instantiated with new operator")
    void isStackInstantiatedWithNewOperator() {
    }

    /**
     * @author Binnur Kurt <binnur.kurt@gmail.com>
     */
    @Nested
    @DisplayName("When new stack")
    class WhenNew {

        @DisplayName("is empty")
        @Test
        void isEmpty() {
        }

        @Test
        @DisplayName("throws EmptyStackException when popped")
        void throwsExceptionWhenPopped() {
        }

        @Test
        @DisplayName("throws EmptyStackException when peeked")
        void throwsExceptionWhenPeeked() {
        }
    }

    /**
     * @author Binnur Kurt <binnur.kurt@gmail.com>
     */
    @Nested
    @DisplayName("after pushing one element")
    class AfterPushing {

        @DisplayName("is not empty")
        @Test
        void notEmpty() {
        }

        @Test
        @DisplayName("returns the element when popped and is empty")
        void returnElementWhenPopped() {
        }

        @Test
        @DisplayName("returns the element when peeked and is not empty")
        void returnElementWhenPeeked() {
        }
    }
}
