
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class mergeJson {

	public static void main(String[] args) throws Exception{
		String json1 = "{ \"name\": \"Abhay\", \"email\": \"abhay@gmail.com\" }";
        String json2 = "{ \"phone\": \"9876543210\", \"city\": \"Agra\" }";

        ObjectMapper obj = new ObjectMapper();

        JsonNode node1 = obj.readTree(json1);
        JsonNode node2 = obj.readTree(json2);

        ObjectNode merge = obj.createObjectNode();

        merge.setAll((ObjectNode) node1);
        merge.setAll((ObjectNode) node2);

        System.out.println(merge.toPrettyString());

	}

}
