package com.bridgelabz.junit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import jar.StringMethod;

public class StringMethodTest {
	@Test
    void testReverse() {
        assertEquals("olleh", StringMethod.reverse("hello"));
        assertNull(StringMethod.reverse(null));
    }

    @Test
    void testIsPalindrome() {
        assertTrue(StringMethod.isPalindrome("madam"));
        assertTrue(StringMethod.isPalindrome("RaceCar"));
        assertFalse(StringMethod.isPalindrome(null));
    }

    @Test
    void testToUpperCase() {
        assertEquals("HELLO", StringMethod.toUpperCase("hello"));
        assertNull(StringMethod.toUpperCase(null));
    }
}