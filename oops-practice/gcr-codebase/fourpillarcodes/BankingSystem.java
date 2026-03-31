import java.util.*;
interface Loanable{
	void applyForLoan(double amount);
    double calculateLoanEligibility();
}
abstract class BankAccount{
	private long accountNumber;
	private String holderName;
	private double balance;
	
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	BankAccount(long accountNumber,String holderName,double balance){
		this.accountNumber = accountNumber;
		this.holderName = holderName;
		this.balance = balance;
	}
	abstract double calculateInterest();
	//deposit method
		public void deposit(double amount) {
			if(amount>0) {
				balance += amount;
				System.out.println("Deposit $"+amount);
			}
			else {
				System.out.println("Invalid Deposit Amount");
			}
		}
		//withdraw
		public void withdraw(double amount) {
			if(amount > 0 && amount <= balance) {
				balance -= amount;
				System.out.println("Withdraw $:"+amount);
			}
			else {
				System.out.println("Insufficient balance or invalid amount");
			}
		}
}
class SavingsAccount extends BankAccount implements Loanable{

	SavingsAccount(long accountNumber, String holderName, double balance) {
		super(accountNumber, holderName, balance);
		
	}

	@Override
	double calculateInterest() {
		
		return getBalance()*0.04;
	}

	@Override
	public void applyForLoan(double amount) {
		System.out.println("Savings Account Loan Applied: ₹" + amount);
		
	}

	@Override
	public double calculateLoanEligibility() {
		// TODO Auto-generated method stub
		return getBalance() * 5;
	}
	
}
class CurrentAccount extends BankAccount implements Loanable{

	CurrentAccount(long accountNumber, String holderName, double balance) {
		super(accountNumber, holderName, balance);
		
	}

	@Override
	double calculateInterest() {
		
		return getBalance()*0.02;
	}

	@Override
	public void applyForLoan(double amount) {
		System.out.println("Savings Account Loan Applied: ₹" + amount);
		
	}

	@Override
	public double calculateLoanEligibility() {
		
		return getBalance() * 5;
	}
	
}
public class BankingSystem {
	public static void main(String[] args) {
		List<BankAccount> accounts = new ArrayList<>();

        accounts.add(new SavingsAccount(101001, "Rohit", 50000));
        accounts.add(new CurrentAccount(202002, "Anita", 80000));

        for (BankAccount acc : accounts) {

            System.out.println("Account Holder: " + acc.getHolderName());
            System.out.println("Account Number: " + acc.getAccountNumber());

            double interest = acc.calculateInterest();
            System.out.println("Interest Earned: ₹" + interest);

            acc.deposit(5000);
            acc.withdraw(2000);

            if (acc instanceof Loanable) {
                Loanable loan = (Loanable) acc;
                loan.applyForLoan(100000);
                System.out.println("Loan Eligibility: ₹" + loan.calculateLoanEligibility());
            }

            System.out.println("-----------------------------");
	}
	}
}