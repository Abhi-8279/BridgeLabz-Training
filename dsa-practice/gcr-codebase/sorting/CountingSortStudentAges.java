import java.util.Scanner;

public class CountingSortStudentAges {

    public static void countingSort(int[] ages) {
        int minAge = 10;
        int maxAge = 18;

        int range = maxAge - minAge + 1;
        int[] count = new int[range];
        int[] output = new int[ages.length];

        for (int age : ages) {
            count[age - minAge]++;
        }

        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        for (int i = ages.length - 1; i >= 0; i--) {
            int age = ages[i];
            output[count[age - minAge] - 1] = age;
            count[age - minAge]--;
        }

        for (int i = 0; i < ages.length; i++) {
            ages[i] = output[i];
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the size:");
        int n = in.nextInt();

        int[] studentAges = new int[n];
        System.out.println("Enter the Ages:");
        for (int i = 0; i < n; i++) {
            studentAges[i] = in.nextInt();
        }

        
        
        
        System.out.println("Before Sorting:");
        for (int age : studentAges) {
            System.out.print(age + " ");
        }

        countingSort(studentAges);

        System.out.println("\nAfter Sorting:");
        for (int age : studentAges) {
            System.out.print(age + " ");
        }
    }
}
