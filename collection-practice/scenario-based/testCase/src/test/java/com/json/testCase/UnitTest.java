package com.json.testCase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class UnitTest {
	@Test
	public void Test_Deposit_ValidAmount() {
		Program acc = new Program(8000.0);
		acc.deposit(200.0);
		assertEquals(8200.0, acc.getBalance());
	}
	@Test
	public void Test_Deposit_NegativeAmount() {
		Program acc = new Program(8000.0);
		assertEquals("Deposit amount cannot be negative", assertThrows(RuntimeException.class,() -> acc.deposit(-30.0)).getMessage());
	}
	@Test
	public void Test_Withdraw_ValidAmount() {
		Program acc = new Program(8000.0);
		acc.withdraw(1000.0);
		assertEquals(7000.0, acc.getBalance());
	}
	@Test
	public void Test_Withdraw_InsufficientFunds() {
		Program acc = new Program(8000.0);
		assertEquals("Insufficient funds", assertThrows(RuntimeException.class, () -> acc.withdraw(9000.0)).getMessage());
	}

}
