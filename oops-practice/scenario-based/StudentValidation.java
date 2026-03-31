import java.util.*;
public class StudentValidation{
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n= sc.nextInt();
		sc.nextLine();
		
		for(int i=0;i<n;i++) {
			String str=sc.nextLine();
			
			if(str==null || str.length()==0) {
				System.out.println("Invalid Input (empty string)");
				continue;
			}
			if(str.length()<6) {
				System.out.println("Invalid Input (length < 6)");
				continue;
			}
			if(str.contains(" ")) {
				System.out.println("Invalid Input (Contains Spaces)");
				continue;
			}
			if(!str.matches("[a-zA-Z]+")) {
				if(str.matches(".*\\d.*" )) {
					System.out.println("Invalid Input (Contains Digits)");
					continue;
				}
				else {
					System.out.println("InValid Input(contain special characters)");
					continue;
				}
					
			}
			//Lowercase
			str=str.toLowerCase();
			
			//Remove even ASCII Characters
			StringBuilder filter=new StringBuilder();
			
			for(char ch:str.toCharArray()) {
				if((int)ch%2==0) {
					continue;
				}
				filter.append(ch);
			}
			String st2=filter.reverse().toString();
			
			StringBuilder str3=new StringBuilder();
			for(int j=0;j<st2.length();j++) {
			
				if(j%2!=0) {
					str3.append(st2.charAt(j));
				}
				else {
					str3.append(Character.toUpperCase(st2.charAt(j)));
				}
				
			}
			 System.out.println("The generated key is - " + str3.toString());
			
		}
		
	}
}