import java.util.*;

interface IRentable{
	public double calculateRent(int days);
}

abstract class Vehicle implements IRentable{
	protected int vehicleId;
	protected String brand;
	protected double pricePerDay;
	public Vehicle(int vehicleId,String brand,double pricePerDay) {
		this.vehicleId = vehicleId;
		this.brand = brand;
		this.pricePerDay = pricePerDay;
	}
	
	public abstract void displayDetails();
}

class Car extends Vehicle{
	public Car(int vehicleId,String brand,double pricePerDay) {
		super(vehicleId,brand,pricePerDay);
	}
	
	@Override
	public double calculateRent(int days) {
		return days*pricePerDay;
	}
	
	@Override
	public void displayDetails() {
		System.out.println("Car Details: ");
		System.out.println("Car Id: "+vehicleId);
		System.out.println("Car Brand: "+brand);
		System.out.println();
	}
}

class Bike extends Vehicle{
	public Bike(int vehicleId,String brand,double pricePerDay) {
		super(vehicleId,brand,pricePerDay);
	}
	
	@Override
	public double calculateRent(int days) {
		return (days*pricePerDay)+500;
	}
	
	@Override
	public void displayDetails() {
		System.out.println("Bike Details: ");
		System.out.println("Bike Id: "+vehicleId);
		System.out.println("Bike Brand: "+brand);
		System.out.println();
	}
}

class Truck extends Vehicle{
	public Truck(int vehicleId,String brand,double pricePerDay) {
		super(vehicleId,brand,pricePerDay);
	}
	
	@Override
	public double calculateRent(int days) {
		return (days*pricePerDay)+1000;
	}
	
	@Override
	public void displayDetails() {
		System.out.println("Truck Details: ");
		System.out.println("Truck Id: "+vehicleId);
		System.out.println("Truck Brand: "+brand);
		System.out.println();
	}
}

class Customer{
	private int customerId;
	private String customerName;
	public Customer(int customerId,String customerName) {
		this.customerId = customerId;
		this.customerName = customerName;
	}
	public void displayCustomerDetails() {
		System.out.println("Customer Details: ");
		System.out.println("Customer Id: "+customerId);
		System.out.println("Customer Name: "+customerName);
		System.out.println();
	}
	
}

class Rental{
	private Customer customer;
	private Vehicle vehicle;
	private int days;
	public Rental(Customer customer,Vehicle vehicle,int days) {
		this.customer = customer;
		this.vehicle = vehicle;
		this.days = days;
	}
	
	public void generateBill() {
		customer.displayCustomerDetails();
		vehicle.displayDetails();
		System.out.println("Days: "+days);
		System.out.println("Total bill: "+vehicle.calculateRent(days));
	}
}

class VehicleOperations{
	private ArrayList<Vehicle> vehicles = new ArrayList<>();
	
	//create
	public void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
	}
	
	//read
	public void displayVehicles() {
		for(Vehicle v: vehicles) {
			v.displayDetails();
		}
	}
	
	//update
	public void updateVehiclePrice(int Id,double price) {
		for(Vehicle v: vehicles) {
			if(v.vehicleId == Id) {
				v.pricePerDay = price;
			}
		}
	}
	
	//delete
	public void removeVehicle(int Id) {
		for(int i = 0;i < vehicles.size();i++) {
			if(vehicles.get(i).vehicleId == Id) {
				vehicles.remove(i);
			}
		}
	}
}

public class VechileRentalSystem {

	public static void main(String[] args) {
		
		VehicleOperations operation = new VehicleOperations();

        Vehicle car = new Car(1, "Honda", 1200);
        Vehicle bike = new Bike(2, "Yamaha", 400);
        Vehicle truck = new Truck(3, "Tata", 2000);

        
        operation.addVehicle(car);
        operation.addVehicle(bike);
        operation.addVehicle(truck);

        
        System.out.println("All Vehicles:");
        operation.displayVehicles();

        
        operation.updateVehiclePrice(2, 450);

        
        operation.removeVehicle(3);

        System.out.println("After Update and Delete:");
        operation.displayVehicles();

        
        Customer customer = new Customer(101, "Harshdeep");
        Rental rental = new Rental(customer, car, 3);

        System.out.println("Rental Bill:");
        rental.generateBill();

	}

}