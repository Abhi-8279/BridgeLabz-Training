package InventoryManagementSystem;

public class InventoryApp {

	public static void main(String[] args) {
		
		Inventory inventory = new Inventory();

        Product product1 = new Product(101, "Iphone", 10);
        Product product2 = new Product(102, "Macbook", 4);

        inventory.addProduct(product1);
        inventory.addProduct(product2);

        try {
            inventory.updateStock(101, -6);
            inventory.updateStock(102, -3);
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        }

        inventory.displayInventory();

	}

}
