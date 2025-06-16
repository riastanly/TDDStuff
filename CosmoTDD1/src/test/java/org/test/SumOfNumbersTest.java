package org.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SumOfNumbersTest {

    /*@Test
    public void testGetSumOfTwoNumbers() {
        SumOfNumbers sumOfNumbers = new SumOfNumbers();
        int c = sumOfNumbers.getSum(2, 3);
        assertEquals(5, c);
    }

    @Test
    public void testGetSumFailureCase() {
        SumOfNumbers sumOfNumbers = new SumOfNumbers();
        int c = sumOfNumbers.getSum(3, 3);
        assertEquals(6, c);
    }*/

    @ParameterizedTest
    @MethodSource("sumTestCases")
    public void testGetSumOfTwoNumbers(int a, int b, int expected) {
        SumOfNumbers sumOfNumbers = new SumOfNumbers();
        int c = sumOfNumbers.getSum(a,b);
        assertEquals(expected, c);
    }

    private static Stream<Arguments> sumTestCases() {
        return Stream.of(
                Arguments.of(2,3,5),
                Arguments.of(6,6,12)
        );
    }
}