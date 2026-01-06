class BankAccount {

    private String accountNumber;
    private double balance;

    // Constructor
    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Deposit method
    void deposit(double amount){
        if(amount>0){
            balance += amount;
            System.out.println("Deposited amount"+ balance);
        }else{
            System.out.println("Invalid deposit amount");
        }
    }

    // Withdraw method
    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance. Withdrawal denied.");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        }
    }

    // Check balance method
    void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    // Test the class
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("ACC12345", 5000);

        acc.checkBalance();
        acc.deposit(2000);
        acc.withdraw(1000);
        acc.withdraw(8000);   // denied
        acc.checkBalance();
    }
}
