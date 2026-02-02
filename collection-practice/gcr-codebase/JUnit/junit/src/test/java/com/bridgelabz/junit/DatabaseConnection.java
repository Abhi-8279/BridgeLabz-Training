package com.bridgelabz.junit;

public class DatabaseConnection {
	private static boolean connected;
	
	public static void connect() {
		// Simulate database connection
		connected = true;
	}
	
	public static void disconnect() {
		// Simulate closing database connection
		connected = false;
	}
	
	public static boolean isConnected() {
		return connected;
	}
}
