package EcommerceOrderManagementSystem;

public class WalletPayment implements Payment{
	public void pay(double amount) throws PaymentFailedException {
        if (amount > 50000)
            throw new PaymentFailedException("Card limit exceeded");
        System.out.println("Paid ₹" + amount + " using Card");
    }
}
