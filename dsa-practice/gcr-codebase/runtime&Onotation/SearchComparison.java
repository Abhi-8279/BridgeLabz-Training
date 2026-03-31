import java.util.Arrays;
import java.util.Scanner;

public class SearchComparison {

    // Linear Search - O(N)
    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    // Binary Search - O(log N)
    static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i]= sc.nextInt();
        }
       int target= sc.nextInt();

        // Linear Search
        long startLinear = System.nanoTime();
        int linearResult = linearSearch(arr, target);
        long endLinear = System.nanoTime();

        // Sort array for Binary Search
        Arrays.sort(arr);

        // Binary Search
        long startBinary = System.nanoTime();
        int binaryResult = binarySearch(arr, target);
        long endBinary = System.nanoTime();

        System.out.println("Linear Search Result: " + linearResult);
        System.out.println("Linear Search Time: " + (endLinear - startLinear) + " ns");

        System.out.println("Binary Search Result: " + binaryResult);
        System.out.println("Binary Search Time: " + (endBinary - startBinary) + " ns");
    }
}
