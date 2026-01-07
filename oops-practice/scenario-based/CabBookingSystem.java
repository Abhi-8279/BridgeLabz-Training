import java.util.*;

interface FareCalculator{
	double fareCalculator(double distance);
}
class NormalFare implements FareCalculator {

	@Override
	public double fareCalculator(double distance) {
		return distance * 10;
	}
    
}
class PeakFare implements FareCalculator {

	@Override
	public double fareCalculator(double distance) {
		// TODO Auto-generated method stub
		return distance * 15;
	}
    
}
class NoDriverAvailableException extends Exception {
    public NoDriverAvailableException(String message) {
        super(message);
    }
}

abstract class User {
    private int userID;
    private String userName;
    protected String location;
    private boolean isActive = true;

    protected List<String> rideHistory = new ArrayList<>();

    public User(int userID, String userName, String location) {
        this.userID = userID;
        this.userName = userName;
        this.location = location;
    }

    public abstract void rideBook();

    public void addRide(String ride) {
        rideHistory.add(ride);
    }

    public void viewRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("No rides yet.");
        } else {
            rideHistory.forEach(System.out::println);
        }
    }

    public void deactivateAccount() {
        isActive = false;
    }

    public boolean isActive() {
        return isActive;
    }
}

	
	class Driver extends User {
	    private boolean isAvailable = true;

	    public Driver(int userID, String name, String location) {
	        super(userID, name, location);
	    }

	    public boolean isAvailable() {
	        return isAvailable;
	    }

	    public void acceptRide() {
	        isAvailable = false;
	        System.out.println("Driver accepted the ride.");
	    }

	    public void completeRide(String dropLocation) {
	        isAvailable = true;
	        this.location = dropLocation;
	        System.out.println("Ride completed.");
	    }

	    @Override
	    public void rideBook() {
	        // Driver does not book rides
	    }
	}


class Rider extends User {

    public Rider(int userID, String name, String location) {
        super(userID, name, location);
    }

    @Override
    public void rideBook() {
        System.out.println("Ride requested by rider.");
    }
}
class Ride {
    private Rider rider;
    private Driver driver;
    private double distance;
    private FareCalculator fareCalculator;

    public Ride(Rider rider, Driver driver, double distance, FareCalculator fareCalculator) {
        this.rider = rider;
        this.driver = driver;
        this.distance = distance;
        this.fareCalculator = fareCalculator;
    }

    public double calculateFare() {
        return fareCalculator.fareCalculator(distance);
    }
}
class RideManager {

    public static void bookRide(
            Rider rider,
            Driver driver,
            double distance,
            boolean isPeak
    ) throws NoDriverAvailableException {

        if (!driver.isAvailable()) {
            throw new NoDriverAvailableException("No driver available!");
        }

        FareCalculator calculator = isPeak ? new PeakFare() : new NormalFare();

        driver.acceptRide();

        Ride ride = new Ride(rider, driver, distance, calculator);
        double fare = ride.calculateFare();

        rider.addRide("Ride completed | Fare: ₹" + fare);
        driver.completeRide("Destination");

        System.out.println("Ride Fare: ₹" + fare);
    }
}

public class CabBookingSystem {
	public static void main(String[] args) {

        Rider rider = new Rider(1, "Amit", "Delhi");
        Driver driver = new Driver(101, "Ramesh", "Delhi");

        try {
            RideManager.bookRide(rider, driver, 12, true);
            rider.viewRideHistory();
        } catch (NoDriverAvailableException e) {
            System.out.println(e.getMessage());
        }
    }
}