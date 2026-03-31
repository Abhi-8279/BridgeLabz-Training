import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
      
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();
        
      
        int[][] marks = new int[n][3];
        double[] percentages = new double[n];
        char[] grades = new char[n];
        
        
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter marks for student " + (i + 1) + ":");
            for (int j = 0; j < 3; j++) {
                int mark = -1;
                while (mark < 0) {
                    System.out.print("Subject " + (j + 1) + " (0-100): ");
                    mark = sc.nextInt();
                    if (mark < 0) {
                        System.out.println("Invalid input. Please enter a positive value.");
                    } else {
                        marks[i][j] = mark;
                    }
                }
            }
        }
        
        
        for (int i = 0; i < n; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            percentages[i] = (double) total / 3;
            
          
            if (percentages[i] >= 80) grades[i] = 'A';
            else if (percentages[i] >= 70) grades[i] = 'B';
            else if (percentages[i] >= 60) grades[i] = 'C';
            else if (percentages[i] >= 50) grades[i] = 'D';
            else if (percentages[i] >= 40) grades[i] = 'E';
            else grades[i] = 'R';
        }
        
        
        System.out.println("\nStudent Results:");
        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + ":");
            System.out.println("Physics: " + marks[i][0] + ", Chemistry: " + marks[i][1] + ", Maths: " + marks[i][2]);
            System.out.printf("Percentage: %.2f%%\n", percentages[i]);
            System.out.println("Grade: " + grades[i]);
            System.out.println();
        }
        
        sc.close();
    }
}


