import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;

class User{
	public String name;
	public String email;
	public int age;
	public String city;
	
}

public class ReadJson {

	public static void main(String[] args) {
		try {
			ObjectMapper obj = new ObjectMapper();
			User user = obj.readValue(new File("D:\\BT\\BridgeLabz-Training\\io-programming-practice\\gcr-codebase\\jsonHandling\\src\\main\\java\\user3.json"),
					User.class);
			System.out.println("User Name: "+user.name);
			System.out.println("User email: "+user.email);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
