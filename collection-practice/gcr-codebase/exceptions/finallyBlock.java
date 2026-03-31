import java.util.Scanner;

public class finallyBlock {
	public static void main(String[] args) {
		try(Scanner in = new Scanner(System.in))
		{
			int a=in.nextInt();
			int b=in.nextInt();
			System.out.println("Addition is "+a+b);
			System.out.println("Substraction is " +(a-b));
			System.out.println("Multiplication is "+a*b);
			System.out.println("Division is "+a/b);
			
		}
		catch (ArithmeticException e) {
			System.out.println(e.getMessage());
			
		}
		finally {
			System.out.println("Operation completed");
		}
		
	}

}
