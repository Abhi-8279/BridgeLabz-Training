
import java.io.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MergeJsonFiles {

	public static void main(String[] args) throws Exception{
		
		ObjectMapper mapper = new ObjectMapper();

        JsonNode json1 = mapper.readTree(new File("D:\\BT\\BridgeLabz-Training\\io-programming-practice\\gcr-codebase\\jsonHandling\\src\\main\\java\\user2.json"));
        JsonNode json2 = mapper.readTree(new File("D:\\BT\\BridgeLabz-Training\\io-programming-practice\\gcr-codebase\\jsonHandling\\src\\main\\java\\user3.json"));

        ObjectNode merged = mapper.createObjectNode();

        merged.setAll((ObjectNode) json1);
        merged.setAll((ObjectNode) json2);

        String result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(merged);
        System.out.println(result);

	}

}
