
import com.fasterxml.jackson.databind.ObjectMapper;

class Car {
    public String brand;
    public String model;
    public int year;

    Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
}

public class JavaObjecttoJSON {

	public static void main(String[] args) throws Exception{
		Car car = new Car("Toyota", "Innova", 2021);

        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(car));

	}

}
