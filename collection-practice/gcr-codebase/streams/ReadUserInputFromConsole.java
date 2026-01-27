import java.io.*;
public class ReadUserInputFromConsole {
	public static void main(String[] args) {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Enter your name- ");
            String name =br.readLine();
            System.out.print("Enter your age- ");
            String age =br.readLine();
            FileWriter fw=new FileWriter("UserInfo.txt");
            fw.write("User Information- \n");
            fw.write("Name- " +name+ "\n");
            fw.write("Age- " + age);
            fw.close();
            System.out.println("Info saved successfully in UserInfo.txt");
        } catch (IOException e) {
            System.out.println("Error "+e.getMessage());
        }
    }
}