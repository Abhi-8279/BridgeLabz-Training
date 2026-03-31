import java.util.ArrayList;
import java.util.List;

interface GPS{
	String getCurrentLocation();
	String updateLocation();
}

abstract class Vehicle {
	private int vehicleId;
	private String driverName;
	private double ratePerKm;
	
	Vehicle(int vehicleId,String driverName,double ratePerKm){
		this.setVehicleId(vehicleId);
		this.setDriverName(driverName);
		this.setRatePerKm(ratePerKm);
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public double getRatePerKm() {
		return ratePerKm;
	}

	public void setRatePerKm(double ratePerKm) {
		this.ratePerKm = ratePerKm;
	}
	abstract double calculateFare(double distance);
	public void getVehicleDetails() {
		System.out.println("vehicleId: "+vehicleId);
		System.out.println("Driver Name: "+driverName);
		System.out.println("Rate Per Km: "+ratePerKm);
	}
}
class Car extends Vehicle implements GPS{

	private double capRatePerKm;
	Car(int vehicleId, String driverName, double ratePerKm) {
		super(vehicleId, driverName, ratePerKm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getCurrentLocation() {
		return "Current Location: Mumbai";
		
	}

	@Override
	public String updateLocation() {
		return "Updated Loaction is Delhi";
		
	}

	@Override
	double calculateFare(double distance) {
		// TODO Auto-generated method stub
		return distance * getRatePerKm();
	}
	
}
class Bike extends Vehicle implements GPS{

	Bike(int vehicleId, String driverName, double ratePerKm) {
		super(vehicleId, driverName, ratePerKm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getCurrentLocation() {
		return "Current Location: Bhubhneshawr";
		
	}

	@Override
	public String updateLocation() {
		return "Updated Location: Bhopal";
		
	}

	@Override
	double calculateFare(double distance) {
		// TODO Auto-generated method stub
		return distance * getRatePerKm();
	}
	
}
class Auto extends Vehicle implements GPS{

	Auto(int vehicleId, String driverName, double ratePerKm) {
		super(vehicleId, driverName, ratePerKm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getCurrentLocation() {
		return "Current Location:Gokul";
		
	}

	@Override
	public String updateLocation() {
		return "Updated Location is Mathura";
		
	}

	@Override
	double calculateFare(double distance) {
		return distance * getRatePerKm();
	}
	
}
public class RideHailingApplication {
	// Polymorphism Demonstration Method
    public static void processRides(List<Vehicle> vehicles, double distance) {

        for (Vehicle v : vehicles) {
            v.getVehicleDetails();

            double fare = v.calculateFare(distance);
            System.out.println("Fare for " + distance + " km: " + fare);

            if (v instanceof GPS) {
                GPS g = (GPS) v;
                System.out.println(g.getCurrentLocation());
                System.out.println(g.updateLocation());
            }

            System.out.println("-----------------------------");
        }
    }
	public static void main(String[] args) {
		List<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car(101, "Ramesh", 10));
        vehicles.add(new Bike(102, "Manoj", 5));
        vehicles.add(new Auto(103, "Parth", 7));

        double distance = 20;

        processRides(vehicles, distance);
	}
}