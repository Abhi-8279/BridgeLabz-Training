package InventoryManagementSystem;

public class Product {
	private int productId;
	private String productName;
	private int qty;
	
	public Product(int productId,String productName,int qty) {
		this.productId = productId;
		this.productName = productName;
		this.qty = qty;
	}
	
	public int getId() {
		return productId;
	}
	
	public String getName() {
		return productName;
	}
	
	public int getQuantity() {
		return qty;
	}
	
	public void updateQuantity(int newQty) {
		qty += newQty;
	}
	
	public void display() {
        System.out.println(productId + " | " + productName + " | Stock: " + qty);
    }
	
}
