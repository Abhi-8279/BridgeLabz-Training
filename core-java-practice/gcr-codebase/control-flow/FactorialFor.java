import java.util.Scanner;

class FactorialFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();
        int fact = 1;

        if (number > 0) {
            for (int i = 1; i <= number; i++) {
                fact *= i;
            }
            System.out.println(fact);
        }

        sc.close();
    }
}
