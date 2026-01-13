import java.util.*;

// ---------------- OOP: TICKET ----------------
class Ticket {
    int ticketId;
    double price;

    public Ticket(int ticketId, double price) {
        this.ticketId = ticketId;
        this.price = price;
    }

    public String toString() {
        return "TicketID: " + ticketId + " | Price: ₹" + price;
    }
}

// ---------------- EVENT MANAGER ----------------
class EventManager {

    // QUICK SORT
    public void quickSort(Ticket[] tickets, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(tickets, low, high);
            quickSort(tickets, low, pivotIndex - 1);
            quickSort(tickets, pivotIndex + 1, high);
        }
    }

    // PARTITION LOGIC
    private int partition(Ticket[] tickets, int low, int high) {
        double pivot = tickets[high].price;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (tickets[j].price <= pivot) {
                i++;
                swap(tickets, i, j);
            }
        }
        swap(tickets, i + 1, high);
        return i + 1;
    }

    private void swap(Ticket[] tickets, int i, int j) {
        Ticket temp = tickets[i];
        tickets[i] = tickets[j];
        tickets[j] = temp;
    }

    // SHOW TOP N CHEAPEST
    public void showCheapest(Ticket[] tickets, int n) {
        System.out.println("\n🎯 Top " + n + " Cheapest Tickets:");
        for (int i = 0; i < Math.min(n, tickets.length); i++) {
            System.out.println(tickets[i]);
        }
    }

    // SHOW TOP N MOST EXPENSIVE
    public void showExpensive(Ticket[] tickets, int n) {
        System.out.println("\n💎 Top " + n + " Most Expensive Tickets:");
        for (int i = tickets.length - 1; i >= Math.max(0, tickets.length - n); i--) {
            System.out.println(tickets[i]);
        }
    }
}

// ---------------- MAIN CLASS ----------------
public class TicketPriceOptimizer {
    public static void main(String[] args) {

        EventManager manager = new EventManager();

        // -------- EDGE CASE 1: Empty List --------
        Ticket[] empty = {};
        manager.quickSort(empty, 0, empty.length - 1);
        System.out.println("Empty ticket list sorted successfully.");

        // -------- NORMAL CASE --------
        Ticket[] tickets = {
                new Ticket(101, 1500),
                new Ticket(102, 500),
                new Ticket(103, 3000),
                new Ticket(104, 800),
                new Ticket(105, 2500),
                new Ticket(106, 500),    // duplicate price
                new Ticket(107, 1200),
                new Ticket(108, 4500)
        };

        System.out.println("\nBefore Sorting:");
        for (Ticket t : tickets) {
            System.out.println(t);
        }

        // QUICK SORT
        manager.quickSort(tickets, 0, tickets.length - 1);

        System.out.println("\nAfter Sorting (Ascending by Price):");
        for (Ticket t : tickets) {
            System.out.println(t);
        }

        // TOP RESULTS
        manager.showCheapest(tickets, 3);
        manager.showExpensive(tickets, 3);

        // -------- EDGE CASE 2: Single Ticket --------
        Ticket[] single = { new Ticket(201, 999) };
        manager.quickSort(single, 0, single.length - 1);
        System.out.println("\nSingle ticket sorted: " + single[0]);
    }
}
