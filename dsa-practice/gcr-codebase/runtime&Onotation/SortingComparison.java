import java.util.*;

public class SortingComparison {

    // Bubble Sort - O(N^2)
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Merge Sort - O(N log N)
    static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j])
                arr[k++] = L[i++];
            else
                arr[k++] = R[j++];
        }

        while (i < n1)
            arr[k++] = L[i++];

        while (j < n2)
            arr[k++] = R[j++];
    }

    // Quick Sort - O(N log N)
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];


        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] arrBubble = arr.clone();
        
        int[] arrMerge = arr.clone();
        int[] arrQuick = arr.clone();

        // Bubble Sort
        long startBubble = System.nanoTime();
        bubbleSort(arrBubble);
        long endBubble = System.nanoTime();

        // Merge Sort
        long startMerge = System.nanoTime();
        mergeSort(arrMerge, 0, n - 1);
        long endMerge = System.nanoTime();

        // Quick Sort
        long startQuick = System.nanoTime();
        quickSort(arrQuick, 0, n - 1);
        long endQuick = System.nanoTime();

        // Results
        System.out.println("\n Sorting Time Comparison ");
        System.out.println("Bubble Sort Time: " + (endBubble - startBubble) + " ns");
        System.out.println("Merge Sort Time : " + (endMerge - startMerge) + " ns");
        System.out.println("Quick Sort Time : " + (endQuick - startQuick) + " ns");

        sc.close();
    }
}
