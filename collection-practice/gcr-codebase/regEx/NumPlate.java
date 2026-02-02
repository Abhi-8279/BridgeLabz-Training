
public class NumPlate {
	public static void main(String[] args) {
		String regex="^[A-Z]{2}[0-9]{4}$";
		String input="AC1234";
		if(input.matches(regex))System.out.println("TRUE FOUND");
		else System.out.println("WRONG PASSWARD");
	}
	}
