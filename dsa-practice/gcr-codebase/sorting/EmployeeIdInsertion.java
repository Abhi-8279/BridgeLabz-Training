import java.util.Scanner;

public class EmployeeIdInsertion {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	System.out.println("Enter the number of employee");
	int n=in.nextInt();
	        int[] arr = new int[n];
	        
	        System.out.println("Enter the Employye Ids");
	        for(int i=0;i<n;i++)
	        {
	        	 arr[i]=in.nextInt();
	        }
	        for (int i=1;i<n;i++) {
	            int key=arr[i];
	            int j=i-1;
	            while (j>=0 && arr[j]>key) {
	                arr[j+1]=arr[j];
	                j--;
	            }

	            arr[j+1]=key;
	        }

	        for (int num : arr) {
	            System.out.print(num + " ");
	        }
	        in.close();
	    }

}
