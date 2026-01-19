
abstract class Loan {

    
    private double loanAmount;
    private int tenureInYears;

    // Constructor
    public Loan(double loanAmount, int tenureInYears) {
        this.loanAmount = loanAmount;
        this.tenureInYears = tenureInYears;
    }

    
    public double getLoanAmount() {
        return loanAmount;
    }

    public int getTenureInYears() {
        return tenureInYears;
    }

    // Abstraction
    public abstract double calculateInterest();

    
    public void showLoanDetails() {
        System.out.println("Loan Amount : " + loanAmount);
        System.out.println("Tenure      : " + tenureInYears + " years");
        System.out.println("Interest    : " + calculateInterest());
    }
}


class HomeLoan extends Loan {

    private final double interestRate = 8.0;

    public HomeLoan(double amount, int tenure) {
        super(amount, tenure);
    }

    @Override
    public double calculateInterest() {
        return getLoanAmount() * interestRate * getTenureInYears() / 100;
    }
}


class CarLoan extends Loan {

    private final double interestRate = 10.0;

    public CarLoan(double amount, int tenure) {
        super(amount, tenure);
    }

    @Override
    public double calculateInterest() {
        return getLoanAmount() * interestRate * getTenureInYears() / 100;
    }
}


class EducationLoan extends Loan {

    private final double interestRate = 5.0;

    public EducationLoan(double amount, int tenure) {
        super(amount, tenure);
    }

    @Override
    public double calculateInterest() {
        return getLoanAmount() * interestRate * getTenureInYears() / 100;
    }
}

// Main class
public class BankingManagement {

    public static void main(String[] args) {

        // Polymorphism
        Loan loan1 = new HomeLoan(5000000, 20);
        Loan loan2 = new CarLoan(800000, 5);
        Loan loan3 = new EducationLoan(600000, 6);

        loan1.showLoanDetails();
        System.out.println("-----------------------");
        loan2.showLoanDetails();
        System.out.println("-----------------------");
        loan3.showLoanDetails();
    }
}