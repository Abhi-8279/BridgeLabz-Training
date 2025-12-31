import java.util.Scanner;

public class SubstringCount {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	System.out.println("Enter teh substring");
	String sub=in.nextLine();
	System.out.println("Enter teh string");
	String str=in.nextLine();
	int count=0;
    while (str.contains(sub)) {
        count++;
        str=str.substring(str.indexOf(sub)+sub.length());
    }
    System.out.println("The Substring "+sub+" occurs "+count+" times.");
}
}