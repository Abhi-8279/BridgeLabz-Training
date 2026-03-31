
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FilterJson {

	public static void main(String[] args) {
		
		try {
			String jsonArray = "["
                    + "{ \"name\": \"Abhay\", \"age\": 21 },"
                    + "{ \"name\": \"AKriti\", \"age\": 27 },"
                    + "{ \"name\": \"Deepika\", \"age\": 30 },"
                    + "{ \"name\": \"Abhishek\", \"age\": 24 }"
                    + "]";
			
		    ObjectMapper obj = new ObjectMapper();
		    JsonNode root = obj.readTree(jsonArray);
		    System.out.println("Records with age > 25:");

            for (JsonNode node : root) {
                if (node.get("age").asInt() > 25) {
                    System.out.println(node.toPrettyString());
                }
            }
		    
		}catch (Exception e) {
            e.printStackTrace();
        }

	}

}