package jar;

public class DataConnect {
	static boolean connect;
	public static void connect() {
		connect=true;
		System.out.println("Database is connected.");
	}
		
	public static void disconnect() {
		connect=false;
		System.out.println("Database is disconnected.");
	}
		
	public static boolean isConnected() {
		return connect;
	}
}