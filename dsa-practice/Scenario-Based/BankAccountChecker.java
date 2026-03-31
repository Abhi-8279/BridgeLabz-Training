abstract class BankAccount {
    private final String accountNumber;
    protected  double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    abstract double calculateFee();

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
	public void display() {
		// TODO Auto-generated method stub
		
	}
}

// Savings Account
class SavingsAccount extends BankAccount {

    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    double calculateFee() {
        return balance * 0.005; 
    } 
    public void display() {
    	System.out.println("Account Type : Savings Type");
    	System.out.println("Account No : "+getAccountNumber());
    	System.out.println("Charges Applied : "+calculateFee());
    	System.out.println("Balance :"+(getBalance() - calculateFee()));
    }
}

// Checking Account
class CheckingAccount extends BankAccount {

    public CheckingAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    double calculateFee() {
        return balance < 1000 ? 1.0 : 0.0;
    }
    public void display() {
    	System.out.println("Account Type : Checking Type");
    	System.out.println("Account No : "+getAccountNumber());
    	System.out.println("Charges Applied"+calculateFee());
    	System.out.println("Balance :"+(getBalance()-calculateFee()));
    }
}

public class BankAccountChecker {

    public static void main(String[] args) {

        BankAccount savings = new SavingsAccount("12345", 1000.0);
//        System.out.printf("%.2f%n", savings.calculateFee());
        savings.display();

        BankAccount s2 = new SavingsAccount("123456", 500.0);
        System.out.printf("%.2f%n", s2.calculateFee());
        s2.display();

        BankAccount c1 = new CheckingAccount("1234567", 1500.0);
        System.out.printf("%.2f%n", c1.calculateFee());
        c1.display();

        BankAccount c2 = new CheckingAccount("12345678", 500.0);
        System.out.printf("%.2f%n", c2.calculateFee());
        c2.display();
    }
    
}
