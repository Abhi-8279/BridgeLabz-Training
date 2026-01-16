import java.util.Scanner;

public class HeapSalary {

    public static void heapify(int[] salary, int n, int i) {
        int largest = i;        // root
        int left = 2 * i + 1;   // left child
        int right = 2 * i + 2;  // right child

        if (left < n && salary[left] > salary[largest]) {
            largest = left;
        }

        if (right < n && salary[right] > salary[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = salary[i];
            salary[i] = salary[largest];
            salary[largest] = temp;

            heapify(salary, n, largest);
        }
    }

    public static void heapSort(int[] salary) {
        int n = salary.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salary, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = salary[0];
            salary[0] = salary[i];
            salary[i] = temp;

            heapify(salary, i, 0);
        }
    }

    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
         System.out.println("Enter the salary");
         int arr[]=new int[n];
         for(int i=0;i<n;i++)
         {
        	 arr[i]=in.nextInt();
        }

        System.out.println("Before Sorting:");
        for (int s : arr) {
            System.out.print(s + " ");
        }

        heapSort(arr);

        System.out.println("\nAfter Sorting:");
        for (int s : arr) {
            System.out.print(s + " ");
        }
    }
}