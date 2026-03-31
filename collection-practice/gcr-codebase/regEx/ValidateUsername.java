//import java.util.regex.Matcher;
//import java.util.regex.Pattern;

public class ValidateUsername {
	public static void main(String[] args) {
		String regex="^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
		String input="Abhay1234";
//		Pattern pattern = Pattern.compile(regex);
//		Matcher matcher = pattern.matcher(input);
		if(input.matches(regex))System.out.println("TRUE FOUND");
		else System.out.println("WRONG PASSWARD");
	}

}
