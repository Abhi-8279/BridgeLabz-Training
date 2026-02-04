import java.util.Arrays;
import java.util.List;

public class HospitalPatient {

    public static void main(String[] args) {

        List<Integer> patientIds =
                Arrays.asList(101, 102, 103, 104, 105);

        // Method Reference instead of lambda
        patientIds.forEach(System.out::println);
    }
}
