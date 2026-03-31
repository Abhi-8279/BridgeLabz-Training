package InventoryManagementSystem;

public class LowStockAlert implements AlertService{
	
	@Override
	public void sendAlert(Product product) {
		System.out.println("Low Stock Alert for Product ID: "+product.getId());
	}
}
