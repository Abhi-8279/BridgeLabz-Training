import java.util.LinkedHashSet;
import java.util.Scanner;
public class RemoveDupli {
   public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	String str = in.nextLine();
	int l = str.length();
	LinkedHashSet<Character>duplicate = new LinkedHashSet<>();
	for(int i=0;i<l;i++)
	{
		duplicate.add(str.charAt(i));
	}
     System.out.println("After Duplicate Removed from "+str);
     System.out.println("Are");
     for (char ch : duplicate) {
         System.out.print(ch+" ");
     }
     
     
   }
}
