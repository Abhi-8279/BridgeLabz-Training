import java.util.Arrays;
import java.util.List;

public class UpperNAme {

    public static void main(String[] args) {

        List<String> employees =
                Arrays.asList("Abhay", "Rahul", "Neha", "Priya");

        employees.stream()
                 .map(String::toUpperCase)   // Method reference
                 .forEach(System.out::println);
    }
}
