
public class ValidHex {
	public static void main(String[] args) {
		String regex="^#[0-9a-fA-F]{6}$";
		String input= "#FFA500";
		if(input.matches(regex))System.out.println("VALID");
		else System.out.println("NOT VALID");
	}

}
