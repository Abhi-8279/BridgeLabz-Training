

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

class Student {
    public String name;
    public int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class ListToJsonArray {

	public static void main(String[] args) {
		try {
            List<Student> students = new ArrayList<>();
            students.add(new Student("Abhay", 21));
            students.add(new Student("Abhishek", 23));
            students.add(new Student("Naina", 22));

            ObjectMapper mapper = new ObjectMapper();

            String jsonArray = mapper.writeValueAsString(students);

            System.out.println(jsonArray);

        } catch (Exception e) {
            e.printStackTrace();
        }

	}

}
