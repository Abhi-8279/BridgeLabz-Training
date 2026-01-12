import java.util.*;

// ---------------- CUSTOM EXCEPTION ----------------
class OutOfStockException extends Exception {
    public OutOfStockException(String message) {
        super(message);
    }
}

// ---------------- INTERFACE ----------------
interface AlertService {
    void sendLowStockAlert(Product product);
}

// ---------------- ALERT IMPLEMENTATION ----------------
class EmailAlertService implements AlertService {
    public void sendLowStockAlert(Product product) {
        System.out.println(
            "⚠ LOW STOCK ALERT: " + product.getName() +
            " | Available: " + product.getQuantity()
        );
    }
}

// ---------------- OOP: PRODUCT ----------------
class Product {
    private int productId;
    private String name;
    private int quantity;
    private int lowStockThreshold;

    public Product(int productId, String name, int quantity, int lowStockThreshold) {
        this.productId = productId;
        this.name = name;
        this.quantity = quantity;
        this.lowStockThreshold = lowStockThreshold;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getLowStockThreshold() {
        return lowStockThreshold;
    }

    public void addStock(int amount) {
        quantity += amount;
    }

    public void reduceStock(int amount) throws OutOfStockException {
        if (amount > quantity) {
            throw new OutOfStockException(
                "Product " + name + " is out of stock! Requested: " +
                amount + ", Available: " + quantity
            );
        }
        quantity -= amount;
    }
}

// ---------------- OOP: INVENTORY ----------------
class Inventory {
    private Map<Integer, Product> products = new HashMap<>();
    private AlertService alertService;

    public Inventory(AlertService alertService) {
        this.alertService = alertService;
    }

    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
        System.out.println("Product added: " + product.getName());
    }

    public void updateStock(int productId, int change) {
        Product product = products.get(productId);
        if (product == null) {
            System.out.println("Product not found!");
            return;
        }

        try {
            if (change > 0) {
                product.addStock(change);
                System.out.println("Stock increased for " + product.getName());
            } else {
                product.reduceStock(Math.abs(change));
                System.out.println("Stock reduced for " + product.getName());
            }

            monitorStock(product);

        } catch (OutOfStockException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private void monitorStock(Product product) {
        if (product.getQuantity() <= product.getLowStockThreshold()) {
            alertService.sendLowStockAlert(product);
        }
    }

    public void displayInventory() {
        System.out.println("\n--- INVENTORY STATUS ---");
        for (Product p : products.values()) {
            System.out.println(
                p.getProductId() + " | " + p.getName() +
                " | Qty: " + p.getQuantity()
            );
        }
    }
}

// ---------------- MAIN CLASS ----------------
public class InventoryManagementSystem {
    public static void main(String[] args) {

        AlertService alertService = new EmailAlertService();
        Inventory inventory = new Inventory(alertService);

        Product rice = new Product(101, "Rice Bag", 50, 10);
        Product sugar = new Product(102, "Sugar Bag", 20, 5);

        // Add products
        inventory.addProduct(rice);
        inventory.addProduct(sugar);

        inventory.displayInventory();

        // Update stock
        inventory.updateStock(101, -30);   // Reduce stock
        inventory.updateStock(102, -18);   // Trigger low-stock alert

        inventory.displayInventory();

        // Out of stock case
        inventory.updateStock(102, -10);   // Exception

        // Add stock
        inventory.updateStock(102, 50);

        inventory.displayInventory();
    }
}
