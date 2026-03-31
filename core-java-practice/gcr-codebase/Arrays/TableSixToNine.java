import java.util.Scanner;

public class TableSixToNine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        int[] result = new int[4];

        for (int i = 6, j = 0; i <= 9; i++, j++) {
            result[j] = number * i;
            System.out.println(number + " * " + i + " = " + result[j]);
        }
        sc.close();
    }
}
