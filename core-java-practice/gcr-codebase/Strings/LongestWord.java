import java.util.Scanner;
public class LongestWord {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	String str=in.nextLine();
	String[] words = str.split(" ");
	String lword=words[0];
	for(int i=1;i<words.length;i++)
	{
		if(lword.length()<words[i].length())lword=words[i];
	}
	System.out.println("the Longest Word in sentence is "+ lword);
	
}
}
