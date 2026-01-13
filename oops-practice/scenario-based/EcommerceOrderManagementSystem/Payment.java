package EcommerceOrderManagementSystem;

public interface Payment {
	public void pay(double amount) throws PaymentFailedException;
}
