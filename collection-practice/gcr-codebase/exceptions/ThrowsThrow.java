import java.util.Scanner;

public class ThrowsThrow {
	
	public static double calculateInterest(double amount, double rate, int years)throws IllegalArgumentException
	{
		if( amount<0 || rate <0)throw new IllegalArgumentException("Invalid input: Amount and rate must be positive" );
		return (amount*rate*years)/100;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//       Scanner in = new Scanner(System.in);
		
       try(Scanner in = new Scanner(System.in))
       {
    	   System.out.println("enter Amount");
    	   double amount=in.nextDouble();
    	   System.out.println("enter rate");
    	   double rate = in.nextDouble();
    	   System.out.println("enter years");
    	   int years=in.nextInt();
    	   calculateInterest(amount, rate, years);
    	   System.out.println("the Calculated Interest is : "+ calculateInterest(amount, rate, years));
       }
       catch (IllegalArgumentException e) {
    	  System.out.println(e.getMessage());
		// TODO: handle exception
	}
	}

}