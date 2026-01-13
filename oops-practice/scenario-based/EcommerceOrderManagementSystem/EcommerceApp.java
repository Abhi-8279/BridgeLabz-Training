package EcommerceOrderManagementSystem;

public class EcommerceApp {

	public static void main(String[] args) {
		
		Product product1 = new Product(101, "Laptop", 45000, 10);
        Customer customer1 = new Customer(1, "Harshdeep");

        Order order = new Order(1001, product1, 1);

        Payment payment = new UPIPayment();
        order.makePayment(payment);

        order.trackOrder();

	}

}
