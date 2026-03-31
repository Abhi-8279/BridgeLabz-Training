package jar;

//import org.junit.jupiter.api.Test;

class App {
    void testValidHex() {
        String input = "#FFA500";
        boolean bool=input.matches("^#[0-9A-Fa-f]{6}$");
        System.out.println(bool);
    }
    public static void main(String[] args) {
		System.out.println("Welcome to JUnit Testing");
		App app=new App();
		app.testValidHex();
	}
    
}
