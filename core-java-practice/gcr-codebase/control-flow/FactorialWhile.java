import java.util.Scanner;

class FactorialWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();
        int fact = 1;

        if (number > 0) {
            while (number > 0) {
                fact *= number;
                number--;
            }
            System.out.println(fact);
        }

        sc.close();
    }
}

