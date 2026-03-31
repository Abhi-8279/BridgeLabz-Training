import java.util.*;
interface Insurable{
	double calculateInsurance();
	String getInsuranceDetails();
}

abstract class Vehicle{
	private String vehicleNumber;
	private String type;
	private double rentalRate;
	
	Vehicle(String vehicleNumber,String type,double rentalRate){
		this.setVehicleNumber(vehicleNumber);
		this.setType(type);
		this.setRentalRate(rentalRate);
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}
	public abstract double calculateRentalCost(int days);
	public void display() {
		System.out.println("The Vehicle Number: "+vehicleNumber);
		System.out.println("Vehicle Type: "+type);
		System.out.println("Rental Rate: "+rentalRate);
	}
}
class Car extends Vehicle implements Insurable {
	 
	private String insurancePolicyNumber; // encapsulated
	Car(String vehicleNumber, String type, String policyNo,double rentalRate) {
		super(vehicleNumber, "Car", rentalRate);
		this.insurancePolicyNumber = policyNo;
	}

	@Override
	public double calculateRentalCost(int days) {
		// TODO Auto-generated method stub
		return getRentalRate()*days;
	}

	@Override
	public double calculateInsurance() {
		// TODO Auto-generated method stub
		return getRentalRate() * 0.05;
	}

	@Override
	public String getInsuranceDetails() {
		// TODO Auto-generated method stub
		return "Car Insaurance Policy: "+ insurancePolicyNumber;
	}
	
}
class Bike extends Vehicle implements Insurable{
	private String insurancePolicyNumber;
	Bike(String vehicleNumber, String type, double rentalRate,String policyNo) {
		super(vehicleNumber, type, rentalRate);
		this.insurancePolicyNumber = policyNo;
	}

	@Override
	public double calculateRentalCost(int days) {
		// TODO Auto-generated method stub
		return getRentalRate()*days;
	}

	@Override
	public double calculateInsurance() {
		// TODO Auto-generated method stub
		return getRentalRate() * 0.02;
	}

	@Override
	public String getInsuranceDetails() {
		// TODO Auto-generated method stub
		return "Bike Insaurance Ploicy: "+insurancePolicyNumber;
	}
	
}
class Truck extends Vehicle implements Insurable{
	private String insurancePolicyNumber;
	Truck(String vehicleNumber, String type, double rentalRate,String policyNo) {
		super(vehicleNumber, type, rentalRate);
		this.insurancePolicyNumber= policyNo;
	}

	@Override
	public double calculateRentalCost(int days) {
		// TODO Auto-generated method stub
		return getRentalRate()*days;
	}

	@Override
	public double calculateInsurance() {
		// TODO Auto-generated method stub
		return getRentalRate()*0.10;
	}

	@Override
	public String getInsuranceDetails() {
		// TODO Auto-generated method stub
		return "Truck Insaurance Ploicy: "+insurancePolicyNumber;
	}
	
}
public class VehicleRentalSystem {
	public static void main(String[] args) {
		List<Vehicle> vehicle = new ArrayList<>();
		vehicle.add(new Car("UP14AU5789","Sedan","AB20",800));
		vehicle.add(new Bike("UP13GH2341","Hero Honda",300,"AB30"));
		vehicle.add(new Truck("UP41US7654","TATA",100,"US00"));
		
		int days = 3;
		for(Vehicle v:vehicle) {
			v.display();
			double  rentalCost = v.calculateRentalCost(days);
			System.out.println("Rental Cost ("+days+" days): "+rentalCost);
			
			if (v instanceof Insurable) {
                Insurable ins = (Insurable) v;
                System.out.println(ins.getInsuranceDetails());
                System.out.println("Insurance Cost: ₹" + ins.calculateInsurance());
            }
			 System.out.println("----------------------------");
		}
		
	}
}