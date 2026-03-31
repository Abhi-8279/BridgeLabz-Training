import java.util.Scanner;

public class StudentMarks2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int students = sc.nextInt();

        double[][] marks = new double[students][4];
        String[] grade = new String[students];

        for (int i = 0; i < students; i++) {
            double physics = sc.nextDouble();
            double chemistry = sc.nextDouble();
            double maths = sc.nextDouble();

            if (physics < 0 || chemistry < 0 || maths < 0) {
                i--;
                continue;
            }

            marks[i][0] = physics;
            marks[i][1] = chemistry;
            marks[i][2] = maths;
        }

        for (int i = 0; i < students; i++) {
            double total = marks[i][0] + marks[i][1] + marks[i][2];
            double percentage = total / 3;
            marks[i][3] = percentage;

            if (percentage >= 90)
                grade[i] = "A";
            else if (percentage >= 75)
                grade[i] = "B";
            else if (percentage >= 60)
                grade[i] = "C";
            else if (percentage >= 40)
                grade[i] = "D";
            else
                grade[i] = "Fail";
        }

        for (int i = 0; i < students; i++) {
            System.out.println(
                marks[i][0] + " " +
                marks[i][1] + " " +
                marks[i][2] + " " +
                marks[i][3] + " " +
                grade[i]
            );
        }

        sc.close();
    }
}
