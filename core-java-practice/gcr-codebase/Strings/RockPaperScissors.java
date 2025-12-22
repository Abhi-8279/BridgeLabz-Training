import java.util.Scanner;

public class RockPaperScissors {

    static String computerChoice() {
        int r = (int) (Math.random() * 3);
        return r == 0 ? "rock" : r == 1 ? "paper" : "scissors";
    }

    static int winner(String user, String comp) {
        if (user.equals(comp)) return 0;
        if ((user.equals("rock") && comp.equals("scissors")) ||
            (user.equals("paper") && comp.equals("rock")) ||
            (user.equals("scissors") && comp.equals("paper")))
            return 1;
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of games: ");
        int n = sc.nextInt();

        int userWin = 0, compWin = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter choice (rock/paper/scissors): ");
            String user = sc.next();
            String comp = computerChoice();

            int result = winner(user, comp);
            if (result == 1) userWin++;
            if (result == -1) compWin++;

            System.out.println("Computer: " + comp);
        }

        System.out.println("\nRESULTS");
        System.out.println("User Wins: " + userWin);
        System.out.println("Computer Wins: " + compWin);
        System.out.println("User Win %: " + (userWin * 100.0 / n));
        System.out.println("Computer Win %: " + (compWin * 100.0 / n));
    }
}
