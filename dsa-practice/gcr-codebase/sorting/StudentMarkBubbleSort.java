import java.util.Scanner;

public class StudentMarkBubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("enter teh number of students");
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
         System.out.println("Enter the marks of students");
         int arr[]=new int[n];
         for(int i=0;i<n;i++)
         {
        	 arr[i]=in.nextInt();
        }
         
         
         for(int i=0;i<n;i++)
         {
        	 for(int j=0;j<n-i-1;j++)
        	 {
        	 if(arr[j]>arr[j+1])
        	 {
        		 int temp=arr[j];
        		 arr[j]=arr[j+1];
        		 arr[j+1]=temp;
        	 }
         }
	}
         for(int i=0;i<n;i++)
         {
        	 System.out.print(arr[i]+ " < ");
         }

}
}
