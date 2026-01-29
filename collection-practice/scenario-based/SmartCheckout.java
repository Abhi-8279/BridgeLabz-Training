import java.util.*;

public class SmartCheckout {

    static HashMap<String, double[]> inventory = new HashMap<>();

    static Queue<Customer> queue = new LinkedList<>();

    static class Customer {
        String name;
        List<String> items;

        Customer(String name, List<String> items) {
            this.name = name;
            this.items = items;
        }
    }

    static void addItem(String name, double price, int stock) {
        inventory.put(name, new double[]{price, stock});
    }

    // Add customer to queue
    static void addCustomer(Customer customer) {
        queue.offer(customer);
        System.out.println(customer.name + " added to billing queue");
    }

    // Process customer billing
    static void processCustomer() {
        if (queue.isEmpty()) {
            System.out.println("No customers in queue");
            return;
        }

        Customer customer = queue.poll();
        double total = 0;

        System.out.println("\nBilling for: " + customer.name);

        for (String item : customer.items) {
            if (!inventory.containsKey(item)) {
                System.out.println(item + " not available");
                continue;
            }

            double[] details = inventory.get(item);
            double price = details[0];
            int stock = (int) details[1];

            if (stock > 0) {
                total += price;
                details[1]--; // update stock
                System.out.println(item + " - ₹" + price);
            } else {
                System.out.println(item + " is out of stock");
            }
        }

        System.out.println("Total Bill: ₹" + total);
    }

    // Main method
    public static void main(String[] args) {

        // Add inventory
        addItem("Milk", 50, 5);
        addItem("Bread", 30, 3);
        addItem("Eggs", 6, 10);

        // Add customers
        addCustomer(new Customer("Abhay",
                Arrays.asList("Milk", "Bread", "Eggs")));

        addCustomer(new Customer("Unknown",
                Arrays.asList("Bread", "Milk")));

        // Process billing
        processCustomer();
        processCustomer();
    }
}
