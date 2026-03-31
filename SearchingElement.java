import java.util.*;
class SearchingElement {

    public static int search(int[] arr, int target) {
        int low= 0, 
        high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // If target found
            if (arr[mid] == target)
                return mid;

            // Left half 
            if (arr[low] <= arr[mid]) {
                if (target >= arr[low] && target < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
                  // Right half 
            else {
                if (target > arr[mid] && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
         }
         //Target not found
        return -1;
        }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target=sc.nextInt();
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println("Element fount at Index:"+search(arr,target));

        
    }
}
