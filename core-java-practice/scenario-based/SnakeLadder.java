import java.util.Scanner;
import java.util.Random;

public class SnakeLadder {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Random ran = new Random();

        System.out.println("Enter your choice for the players:");
        System.out.println("1 : Single player");
        System.out.println("2 : Two players");

        int n = in.nextInt();

        if (n == 1) {

            int position = 0;
            int diceCount = 0;

            while (position < 100) {
                System.out.println("Move : "+diceCount);
                int dice = ran.nextInt(6) + 1;
                diceCount++;

                int option = ran.nextInt(3); 
                int prePosition = position;

                System.out.println("Dice rolled: " + dice);

                if (option == 0) {
                    System.out.println("No Play");

                } else if (option == 1) {
                    System.out.println("Ladder");
                    position += dice;

                } else {
                    System.out.println("Snake");
                    position -= dice;
                    if (position < 0)
                        position = 0;
                }

                // UC-4: Exact 100 check
                if (position > 100) {
                    position = prePosition;
                }

                System.out.println("Player position: " + position);
                System.out.println("----------------------");
            }

            System.out.println(" won the game!");
            System.out.println("Total dice rolls: " + diceCount);

        } else if (n == 2) {
            System.out.println("Two player logic coming soon...");
        } else {
            System.out.println("Invalid Choice!");
        }
    }
}
