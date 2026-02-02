package com.bridgelabz.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import jar.Calculator;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void testAdd() {
        assertEquals(10, calculator.add(5, 5));
    }

    @Test
    void testSubtract() {
        assertEquals(3, calculator.subtract(8, 5));
    }

    @Test
    void testMultiply() {
        assertEquals(20, calculator.multiply(4, 5));
    }

    @Test
    void testDivide() {
        assertEquals(5, calculator.divide(10, 2));
    }

    @Test
    void testDivideByZero() {
        Exception exception = assertThrows(
                ArithmeticException.class,
                () -> calculator.divide(10, 0)
        );

        Assert.assertEquals("Division by zero is not allowed", exception.getMessage());
    }
}
