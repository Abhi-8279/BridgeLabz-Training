import java.util.*;

public class SearchDataStructureComparison {

    // Array Linear Search - O(N)
    static boolean arraySearch(int[] arr, int target) {
        for (int num : arr) {
            if (num == target)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter dataset size (N): ");
        int n = sc.nextInt();

        System.out.print("Enter element to search: ");
        int target = sc.nextInt();

        int[] arr = new int[n];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();


        for (int i = 0; i < n; i++) {
            arr[i] = i;
            hashSet.add(i);
            treeSet.add(i);
        }

        //  Array Search 
        long startArray = System.nanoTime();
        boolean arrayResult = arraySearch(arr, target);
        long endArray = System.nanoTime();

        //  HashSet Search 
        long startHashSet = System.nanoTime();
        boolean hashSetResult = hashSet.contains(target);
        long endHashSet = System.nanoTime();

        //  TreeSet Search 
        long startTreeSet = System.nanoTime();
        boolean treeSetResult = treeSet.contains(target);
        long endTreeSet = System.nanoTime();

        System.out.println("\n Search Performance Comparison ");

        System.out.println("Array Search Found   : " + arrayResult);
        System.out.println("Array Search Time   : " + (endArray - startArray) + " ns");

        System.out.println("HashSet Search Found: " + hashSetResult);
        System.out.println("HashSet Search Time : " + (endHashSet - startHashSet) + " ns");

        System.out.println("TreeSet Search Found: " + treeSetResult);
        System.out.println("TreeSet Search Time : " + (endTreeSet - startTreeSet) + " ns");

        sc.close();
    }
}
