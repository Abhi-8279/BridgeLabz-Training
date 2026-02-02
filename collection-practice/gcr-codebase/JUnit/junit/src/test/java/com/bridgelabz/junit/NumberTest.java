package com.bridgelabz.junit;

import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import jar.Number;

public class NumberTest{
	// Test with even numbers
    @ParameterizedTest
    @ValueSource(ints ={2, 4, 6})
    public void isEvenTest(int number) {
        assertTrue(Number.isEven(number));
    }

    // Test with odd numbers
    @ParameterizedTest
    @ValueSource(ints ={7, 9})
    public void testIsEvenWithOddNumbers(int number) {
    	assertFalse(Number.isEven(number));
    }

}