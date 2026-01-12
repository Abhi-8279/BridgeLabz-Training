import java.util.*;
interface Payment {
    void pay(double amount) throws PaymentFailedException;
}

class Product {
    int id;
    String name;
    double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

class Customer {
    int customerId;
    String name;

    public Customer(int customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }
}
class CardPayment implements Payment {

    @Override
    public void pay(double amount) throws PaymentFailedException {
        if (amount > 5000) {
            throw new PaymentFailedException("Card limit exceeded");
        }
        System.out.println("Paid " + amount + " using Card");
    }
}
class UpiPayment implements Payment {

    @Override
    public void pay(double amount) throws PaymentFailedException {
        if (amount > 3000) {
            throw new PaymentFailedException("UPI transaction failed");
        }
        System.out.println("Paid " + amount + " using UPI");
    }
}
class WalletPayment implements Payment {

    @Override
    public void pay(double amount) throws PaymentFailedException {
        System.out.println("Paid " + amount + " using Wallet");
    }
}
class Order {
    int orderId;
    Product product;
    Customer customer;
    boolean isPaid = false;

    public Order(int orderId, Product product, Customer customer) {
        this.orderId = orderId;
        this.product = product;
        this.customer = customer;
    }

    public void placeOrder(Payment payment) {
        try {
            payment.pay(product.price);
            isPaid = true;
            System.out.println("Order placed successfully");
        } catch (PaymentFailedException e) {
            System.out.println("Order failed: " + e.getMessage());
        }
    }

    public void cancelOrder() {
        if (isPaid) {
            System.out.println("Refund initiated");
        }
        System.out.println("Order cancelled");
    }
}
public class EcommerceManagement {
    public static void main(String[] args) {

        Product p = new Product(1, "Laptop", 4500);
        Customer c = new Customer(101, "Abhishek");

        Order order = new Order(1001, p, c);

        Payment payment = new UpiPayment(); // polymorphism
        order.placeOrder(payment);

        order.cancelOrder();
    }
}


