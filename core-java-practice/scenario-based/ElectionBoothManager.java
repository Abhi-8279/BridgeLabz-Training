import java.util.*;

public class ElectionBoothManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int candidate1Votes = 0;
        int candidate2Votes = 0;
        int candidate3Votes = 0;

        while (true) {

            System.out.print("\nEnter voter age (or -1 to exit): ");
            int age = sc.nextInt();

            if (age == -1) {
                break;
            }
            if (age >= 18) {
                System.out.println("Eligible to vote");
                System.out.println("Press 1 for Candidate A");
                System.out.println("Press 2 for Candidate B");
                System.out.println("Press 3 for Candidate C");

                int vote = sc.nextInt();

                if (vote == 1) {
                    candidate1Votes++;
                } else if (vote == 2) {
                    candidate2Votes++;
                } else if (vote == 3) {
                    candidate3Votes++;
                } else {
                    System.out.println("Invalid vote!");
                }

            } else {
                System.out.println("Not eligible to vote");
            }
        }

        System.out.println("\n--- Election Result ---");
        System.out.println("Candidate A Votes: " + candidate1Votes);
        System.out.println("Candidate B Votes: " + candidate2Votes);
        System.out.println("Candidate C Votes: " + candidate3Votes);

    
    }
}
