import java.util.InputMismatchException;
import java.util.Scanner;

public class UncheckedArithmatic {
	public static void main(String[] args) {
		
		Scanner in =new Scanner(System.in);
		try {
		System.out.println("Enter two numbers to divide");
		int a=in.nextInt();
		int b=in.nextInt();
		
			System.out.println("The Division of "+a+ "and"+b+ " is "+ a/b);
		}
		catch (ArithmeticException e) {
            System.out.println(e.getMessage());
		}
		catch (InputMismatchException e) {
			System.out.println("Input is Wrong");
          System.out.println(e.getMessage());
		}
		
		
	}
}
