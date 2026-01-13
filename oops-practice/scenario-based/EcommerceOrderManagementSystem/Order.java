package EcommerceOrderManagementSystem;

public class Order {
	private int orderId;
	private Product product;
	private int quantity;
	private String status;
	
	public Order(int orderId,Product product,int quantity) {
		this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
        this.status = "PLACED";
	}
	
	public void makePayment(Payment payment) {
		double totalAmount = product.getPrice() * quantity;
		try {
			payment.pay(totalAmount);
			product.reduceStock(quantity);
			status = "Confirmed";
		}catch(PaymentFailedException e) {
			status = "PAYMENT FAILED";
            System.out.println(e.getMessage());
		}
		
		
	}
	public void cancelOrder() {
        status = "CANCELLED";
        System.out.println("Order Cancelled");
    }

    public void trackOrder() {
        System.out.println("Order Status: " + status);
    }
}
