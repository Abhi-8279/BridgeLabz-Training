package EcommerceOrderManagementSystem;

public class Product {
	private int productId;
	private String productName;
	private double price;
	private int stock;
	
	public Product(int productId,String productName,double price,int stock) {
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.stock = stock;
	}
	
	public String getName() {
		return productName;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void reduceStock(int quantity) {
		stock -= quantity;
	}
	
	public void display() {
        System.out.println(productName + " | Price: " + price + " | Stock: " + stock);
    }
}
