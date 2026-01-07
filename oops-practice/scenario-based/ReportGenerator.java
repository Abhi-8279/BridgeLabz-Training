import java.util.ArrayList;
import java.util.List;

class InvalidMarkException extends Exception {
    public InvalidMarkException(String message) {
        super(message);
    }
}

class Student {
    private String name;
    private String[] subjects;
    private int[] marks;

    public Student(String name, String[] subjects, int[] marks) throws InvalidMarkException {
        if (subjects.length != marks.length) {
            throw new InvalidMarkException("Subjects and marks count mismatch");
        }
        for (int m : marks) {
            if (m < 0 || m > 100) {
                throw new InvalidMarkException("Invalid mark: " + m);
            }
        }
        this.name = name;
        this.subjects = subjects;
        this.marks = marks;
    }

    public double calculateAverage() {
        int sum = 0;
        for (int m : marks) {
            sum += m;
        }
        return (double) sum / marks.length;
    }

    public String assignGrade() {
        double avg = calculateAverage();
        if (avg >= 90) return "A";
        if (avg >= 75) return "B";
        if (avg >= 60) return "C";
        if (avg >= 40) return "D";
        return "F";
    }

    public String generateReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student Name: ").append(name).append("\n");
        sb.append("Subjects & Marks:\n");
        for (int i = 0; i < subjects.length; i++) {
            sb.append(subjects[i]).append(" : ").append(marks[i]).append("\n");
        }
        sb.append("Average: ").append(String.format("%.2f", calculateAverage())).append("\n");
        sb.append("Grade: ").append(assignGrade()).append("\n");
        return sb.toString();
    }
}

public class ReportGenerator {
    public static void main(String[] args) {
        try {
            List<Student> students = new ArrayList<>();

            students.add(new Student(
                    "Abhay",
                    new String[]{"Math", "Science", "English"},
                    new int[]{85, 90, 78}
            ));

            students.add(new Student(
                    "Aashi",
                    new String[]{"Math", "Science", "English"},
                    new int[]{92, 88, 95}
            ));

            for (Student s : students) {
                System.out.println("------------");
                System.out.print(s.generateReport());
            }
        } catch (InvalidMarkException e) {
            System.out.println(e.getMessage());
        }
    }
}