//import java.util.Scanner;
//
//class  InsufficientBalanceException extends Exception
//{
//	
//}
//
//
//
//public class BankException {
//	public static double withdraw(double amount,double bal)throws  InsufficientBalanceException
//	{
//		if(amount<0)throw new IllegalArgumentException();
//		return bal-amount;
//	}
//	
//	
//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		double bal=in.nextInt();
//		double amount=in.nextInt();
//		try {
//			withdraw(amount, bal);
//		} catch (InsufficientBalanceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println(e.getMessage());
//		}
//	}
//	
//	
//
//}



import java.util.Scanner;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class BankException {

    public static double withdraw(double amount, double bal)throws InsufficientBalanceException {
        if (amount<=0)throw new IllegalArgumentException("Amount must be positive");
        if (amount > bal)throw new InsufficientBalanceException("Insufficient balance");
        return bal - amount;
    }
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Enter current balance: ");
            double bal = in.nextDouble();
            System.out.print("Enter withdraw amount: ");
            double amount = in.nextDouble();
            double newBalance = withdraw(amount, bal);
            System.out.println("Withdrawal successful");
            System.out.println("Remaining balance: " + newBalance);
        }
        catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
