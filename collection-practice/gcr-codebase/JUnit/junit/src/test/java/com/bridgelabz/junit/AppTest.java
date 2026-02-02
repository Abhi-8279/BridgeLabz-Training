package com.bridgelabz.junit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test  
    void testValidHex() {
        String input = "#FFA500";
        assertTrue(input.matches("^#[0-9A-Fa-f]{6}$"));
    }
}
