class Product {
    static double discount = 10.0;

    final String productID;
    String productName;
    double price;
    int quantity;

    Product(String productName, double price, int quantity, String productID) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.productID = productID;
    }

    static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    void displayProduct() {
        if (this instanceof Product) {
            System.out.println("Product: " + productName + ", Price: " + price + ", Quantity: " + quantity + ", ID: " + productID);
        }
    }
}
