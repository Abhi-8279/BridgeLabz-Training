package InventoryManagementSystem;

public class Inventory {
	private Product products[] = new Product[5];
	private int count = 0;
	private static final int lowLimit = 5;
	
	public void addProduct(Product product) {
		products[count++] = product;
		System.out.println("Product added");
	}
	
	public void updateStock(int productId,int qty) throws OutOfStockException{
		for(int i = 0;i<count;i++) {
			if (products[i].getId() == productId) {

	            if (products[i].getQuantity() + qty < 0)
	                throw new OutOfStockException("Not enough stock");

	            products[i].updateQuantity(qty);

	            if (products[i].getQuantity() <= lowLimit) {
	                AlertService alert = new LowStockAlert();
	                alert.sendAlert(products[i]);
	            }
	            return;
	        }
		}
	}
	
	public void displayInventory() {
        for (int i = 0; i < count; i++) {
            products[i].display();
        }
    }
}
