import java.util.Scanner;

public class MovieBooking {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean bookingActive = true;
        while (bookingActive) {
            int baseAmount = chooseMovie(input);
            if (baseAmount == -1) {
                continue;
            }

            int finalAmount = baseAmount + chooseSeat(input);
            if (finalAmount == -1) {
                continue;
            }

            finalAmount += addSnacks(input);

            System.out.println("Final Amount to Pay: ₹" + finalAmount);

            System.out.print("Would you like to make another booking? (y/n): ");
            char response = input.next().toLowerCase().charAt(0);

            if (response != 'y') {
                bookingActive = false;
            }
        }

        System.out.println("Booking session closed. Enjoy your movie!");
        input.close();
    }

    private static int chooseMovie(Scanner input) {
        System.out.println("\nChoose Movie Category:");
        System.out.println("1) Action");
        System.out.println("2) Comedy");
        System.out.println("3) Drama");

        int option = input.nextInt();

        switch (option) {
            case 1:
                return 200;
            case 2:
                return 180;
            case 3:
                return 150;
            default:
                System.out.println("Invalid category selected.");
                return -1;
        }
    }

    private static int chooseSeat(Scanner input) {
        System.out.print("Choose Seat Class (Gold/Silver): ");
        String seat = input.next();

        if (seat.equalsIgnoreCase("gold")) {
            return 100;
        } else if (seat.equalsIgnoreCase("silver")) {
            return 50;
        } else {
            System.out.println("Seat selection not valid.");
            return -1;
        }
    }

    private static int addSnacks(Scanner input) {
        System.out.print("Add snacks to your order? (yes/no): ");
        String choice = input.next();

        return choice.equalsIgnoreCase("yes") ? 80 : 0;
    }
}
