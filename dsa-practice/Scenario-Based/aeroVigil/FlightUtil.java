import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FlightUtil {

    static Map<String, FlightInfo> map = new HashMap<>();

    // Flight Number Validation
    public boolean validateFlightNumber(String flightNumber)
            throws InvalidFlightException {

        if (!flightNumber.matches("^FL-[0-9]{4}$")) {
            throw new InvalidFlightException(
                    "The flight number " + flightNumber + " is Invalid"
            );
        }
        return true;
    }

    // Flight Name Validation
    public boolean validateFlightName(String flightName)
            throws InvalidFlightException {

        if (!map.containsKey(flightName)) {
            throw new InvalidFlightException(
                    "The flight name " + flightName + " is Invalid"
            );
        }
        return true;
    }

    // Passenger Capacity Validation
    public boolean validatePassengerCount(int passengerCount, String flightName)
            throws InvalidFlightException {

        FlightInfo info = map.get(flightName);

        if (passengerCount > info.passengerCapacity) {
            throw new InvalidFlightException(
                    "Passenger count exceeds capacity: " + info.passengerCapacity
            );
        }
        return true;
    }

    // Fuel Capacity Validation
    public boolean validateFuelCapacity(int fuelRequired, String flightName)
            throws InvalidFlightException {

        FlightInfo info = map.get(flightName);

        if (fuelRequired > info.fuelCapacity) {
            throw new InvalidFlightException(
                    "Fuel exceeds capacity: " + info.fuelCapacity
            );
        }
        return true;
    }

    public static void main(String[] args) {

        
        map.put("SpiceJet", new FlightInfo(396, 80000));
        map.put("Vistara", new FlightInfo(615, 120000));
        map.put("IndiGo", new FlightInfo(230, 60000));
        map.put("Air Arabia", new FlightInfo(130, 40000));

        try (Scanner in = new Scanner(System.in)) {

            String input = in.nextLine();
            String[] arr = input.split(":");

            FlightUtil obj = new FlightUtil();

            obj.validateFlightNumber(arr[0]);
            obj.validateFlightName(arr[1]);
            obj.validatePassengerCount(Integer.parseInt(arr[2]), arr[1]);

            System.out.println("Flight validated successfully");

        } catch (InvalidFlightException e) {
            System.out.println("Exception Found: " + e.getMessage());
        }
    }
}
