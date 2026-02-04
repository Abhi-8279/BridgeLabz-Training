import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class StudentObjectJSON {

    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        // Create JSON Object
        ObjectNode student = mapper.createObjectNode();
        student.put("name", "Abhay");
        student.put("age", 22);

        // Create JSON Array for subjects
        ArrayNode subjects = mapper.createArrayNode();
        subjects.add("Math");
        subjects.add("Science");
        subjects.add("Computer Science");

        // Add array to object
        student.set("subjects", subjects);

        // Convert to JSON String
        String jsonOutput = mapper.writerWithDefaultPrettyPrinter()
                                  .writeValueAsString(student);

        System.out.println(jsonOutput);
    }
}
