import java.util.Scanner;

public class LineComparison {
	public static void main(String[] args) {
	Scanner in =new Scanner(System.in);
//	UC 1
//	calculate length with using cordinates and Cartisean System
	System.out.println("Welcome to Line Comparison Computation Program");
	System.out.println("Enter Cordinates of  X1 and Y1");
	int x1=in.nextInt();
	int y1=in.nextInt();
	System.out.println("Enter cordinates of X2 and Y2");
	int x2=in.nextInt();
	int y2=in.nextInt();
	Double distance=Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
	System.out.printf("The length is %.2f \n",distance);
//	UC 2
//	check equality of two lines based on the end points
	System.out.println("Enter another cordinates to check the equality of lines");
	System.out.println("Enter Cordinates of  X11 and Y11");
	int x11=in.nextInt();
	int y11=in.nextInt();
	System.out.println("Enter cordinates of X22 and Y22");
	int x22=in.nextInt();
	int y22=in.nextInt();
	Double distance2=Math.sqrt((x22-x11)*(x22-x11) + (y22-y11)*(y22-y11));
	System.out.printf("The  second length is %.2f \n",distance2);
	if(distance.equals(distance2))System.out.println("Both the Lengths are equal");
	else System.out.println("The lengths are not equal");

//  UC 3
//	comparison of two lines based on the end points
	int res=distance.compareTo(distance2);
	if(res>0)System.out.println("Line 1 is greater than Line 2");
	else if (res==0)System.out.println("No Comparison Because Lines are equal");
	else System.out.println("Line 2 is greater tahn Line 1");
	

	
	}
}