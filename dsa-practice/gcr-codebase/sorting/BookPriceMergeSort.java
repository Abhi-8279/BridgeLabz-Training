import java.util.Scanner;

public class BookPriceMergeSort {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	System.out.println("Enter the number of Book");
	int n= in.nextInt();
	System.out.println("Enter the Book prices");
    int arr[]=new int[n];
    for(int i=0;i<n;i++)
    {
    	arr[i]=in.nextInt();
    }
    sort(arr,0,n-1);
    display(arr);
}
   static void merge(int[] arr, int left, int mid, int right) {
        int n1=mid - left + 1;
        int n2=right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j])
                arr[k++] = L[i++];
            else
                arr[k++] = R[j++];
        }

        while (i < n1)arr[k++] = L[i++];

        while (j < n2)arr[k++] = R[j++];
    }

   static void sort(int[] arr, int left, int right) {
        if (left < right) {
        	
            int mid = (left + right) / 2;
            sort(arr, left, mid);
            
            sort(arr, mid + 1, right);
            
            merge(arr, left, mid, right);
        }
    }
   static void display(int arr[])
    {
    	for(int i=0;i<arr.length;i++)
    	System.out.print(arr[i]+" ");
    }
}
