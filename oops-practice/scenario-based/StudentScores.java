import java.util.Scanner;

class StudentScores {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        double[] scores = new double[n];
        double sum = 0, max, min;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter score of student " + (i + 1) + ": ");
            scores[i] = sc.nextDouble();

            if (scores[i] < 0) {
                System.out.println("Invalid score! Enter non-negative value.");
                i--;
                continue;
            }
            sum += scores[i];
        }

        double avg = sum / n;
        max = min = scores[0];

        for (double s : scores) {
            if (s > max) max = s;
            if (s < min) min = s;
        }

        System.out.println("\nAverage Score: " + avg);
        System.out.println("Highest Score: " + max);
        System.out.println("Lowest Score: " + min);

        System.out.println("Scores above average:");
        for (double s : scores)
            if (s > avg) System.out.println(s);

        sc.close();
    }
}
