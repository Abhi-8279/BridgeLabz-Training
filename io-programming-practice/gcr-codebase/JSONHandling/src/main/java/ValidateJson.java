
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateJson {

	public static void main(String[] args) {
		String validJson = "{ \"name\": \"Abhay\", \"email\": \"abha@gmail.com\" }";
        String invalidJson = "{ \"name\": \"Tanuj\", \"email\": \"abhay@gmail.com\" "; // missing closing }

        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonNode node = mapper.readTree(validJson);
            System.out.println("Valid JSON: " + node.toPrettyString());
        } catch (Exception e) {
            System.out.println("Invalid JSON!");
        }

        try {
            JsonNode node = mapper.readTree(invalidJson);
            System.out.println("Valid JSON: " + node.toPrettyString());
        } catch (Exception e) {
            System.out.println("Invalid JSON!");
        }

	}

}
