import java.util.*;

// ---------------- VEHICLE NODE (CIRCULAR LINKED LIST) ----------------
class VehicleNode {
    String vehicleNumber;
    VehicleNode next;

    public VehicleNode(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
        this.next = null;
    }
}

// ---------------- ROUNDABOUT (CIRCULAR LINKED LIST) ----------------
class Roundabout {
    private VehicleNode tail = null;

    // Add vehicle to circular path
    public void addVehicle(String vehicleNumber) {
        VehicleNode newNode = new VehicleNode(vehicleNumber);

        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
        System.out.println("🚗 Vehicle entered roundabout: " + vehicleNumber);
    }

    // Remove vehicle from circular path
    public void removeVehicle(String vehicleNumber) {
        if (tail == null) {
            System.out.println("❌ Roundabout is empty!");
            return;
        }

        VehicleNode curr = tail.next;
        VehicleNode prev = tail;

        do {
            if (curr.vehicleNumber.equals(vehicleNumber)) {
                if (curr == tail && curr.next == tail) {
                    tail = null; // only one vehicle
                } else {
                    prev.next = curr.next;
                    if (curr == tail) {
                        tail = prev;
                    }
                }
                System.out.println("🚦 Vehicle exited roundabout: " + vehicleNumber);
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != tail.next);

        System.out.println("⚠ Vehicle not found in roundabout!");
    }

    // Print roundabout state
    public void printState() {
        if (tail == null) {
            System.out.println("🔴 Roundabout is empty.");
            return;
        }

        System.out.print("🌀 Roundabout State: ");
        VehicleNode curr = tail.next;
        do {
            System.out.print(curr.vehicleNumber + " -> ");
            curr = curr.next;
        } while (curr != tail.next);
        System.out.println("(back to start)");
    }

    public boolean isEmpty() {
        return tail == null;
    }
}

// ---------------- QUEUE (WAITING VEHICLES) ----------------
class VehicleQueue {
    private String[] queue;
    private int front = 0, rear = -1, size = 0;

    public VehicleQueue(int capacity) {
        queue = new String[capacity];
    }

    public void enqueue(String vehicleNumber) {
        if (size == queue.length) {
            System.out.println("🚧 Queue Overflow! Cannot add " + vehicleNumber);
            return;
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = vehicleNumber;
        size++;
        System.out.println("🅿 Vehicle waiting: " + vehicleNumber);
    }

    public String dequeue() {
        if (size == 0) {
            System.out.println("🚫 Queue Underflow! No vehicles waiting.");
            return null;
        }
        String vehicle = queue[front];
        front = (front + 1) % queue.length;
        size--;
        return vehicle;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printQueue() {
        if (size == 0) {
            System.out.println("🅿 Waiting Queue is empty.");
            return;
        }

        System.out.print("🅿 Waiting Queue: ");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % queue.length] + " ");
        }
        System.out.println();
    }
}

// ---------------- MAIN CLASS ----------------
public class TrafficManager {
    public static void main(String[] args) {

        Roundabout roundabout = new Roundabout();
        VehicleQueue waitingQueue = new VehicleQueue(3);

        // Vehicles arrive
        waitingQueue.enqueue("CAR-101");
        waitingQueue.enqueue("CAR-102");
        waitingQueue.enqueue("CAR-103");

        // Queue overflow case
        waitingQueue.enqueue("CAR-104");

        waitingQueue.printQueue();

        // Move vehicles from queue to roundabout
        for (int i = 0; i < 3; i++) {
            String vehicle = waitingQueue.dequeue();
            if (vehicle != null) {
                roundabout.addVehicle(vehicle);
            }
        }

        roundabout.printState();

        // Queue underflow case
        waitingQueue.dequeue();

        // Exit vehicles
        roundabout.removeVehicle("CAR-102");
        roundabout.printState();

        // Remove non-existing vehicle
        roundabout.removeVehicle("CAR-999");

        // Remove remaining vehicles
        roundabout.removeVehicle("CAR-101");
        roundabout.removeVehicle("CAR-103");

        roundabout.printState();
    }
}

