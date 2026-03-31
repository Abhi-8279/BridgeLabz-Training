import java.util.Scanner;

public class FestivalLuckyDraw {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.print("Enter lucky number (or -1 to exit): ");
            int number = sc.nextInt();

            // exit condition
            if (number == -1) {
                System.out.println("Lucky draw closed.");
                break;
            }

            // invalid input
            if (number <= 0) {
                System.out.println("Invalid number! Try again.");
                continue;
            }

            // check divisibility
            if (number % 3 == 0 && number % 5 == 0) {
                System.out.println("🎉 Congratulations! You won a gift!");
            } else {
                System.out.println("Sorry, better luck next time.");
            }
        }
    }
}
