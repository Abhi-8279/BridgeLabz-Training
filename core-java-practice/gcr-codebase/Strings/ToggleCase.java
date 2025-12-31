import java.util.Scanner;

public class ToggleCase {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	String str=in.nextLine();
	String s="";
	for(int i=0;i<str.length();i++)
	{
		if(Character.isUpperCase(str.charAt(i)))
			{
			s=s+Character.toLowerCase(str.charAt(i));
			
			}
		else s=s+Character.toUpperCase(str.charAt(i));
	}
	System.out.println("toggled String is : "+s);
}
}
