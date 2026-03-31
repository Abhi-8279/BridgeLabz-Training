package com.bridgelabz.junit;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import jar.ExceptionHandle;
public class ExceptionHandleTest {
	@Test
	void divideTest() {
		assertThrows(ArithmeticException.class, 
				() -> {ExceptionHandle.divide(12, 0);});
	}
}