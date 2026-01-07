import java.util.ArrayList;
import java.util.List;

class InvalidQuizSubmissionException extends Exception {
    public InvalidQuizSubmissionException(String message) {
        super(message);
    }
}

class QuizProcessor {

    public static int calculateScore(String[] correctAnswers, String[] userAnswers)
            throws InvalidQuizSubmissionException {

        if (correctAnswers.length != userAnswers.length) {
            throw new InvalidQuizSubmissionException("Answer length mismatch");
        }

        int score = 0;
        for (int i = 0; i < correctAnswers.length; i++) {
            if (correctAnswers[i].equalsIgnoreCase(userAnswers[i])) {
                score++;
            }
        }
        return score;
    }

    public static String calculateGrade(int score, int total) {
        double percentage = (score * 100.0) / total;

        if (percentage >= 90) return "A";
        if (percentage >= 75) return "B";
        if (percentage >= 60) return "C";
        if (percentage >= 40) return "D";
        return "F";
    }
}

public class O nlineQuiz {
    public static void main(String[] args) {
        try {
            String[] correctAnswers = {"A", "B", "C", "D", "A"};
            List<Integer> userScores = new ArrayList<>();

            String[] user1 = {"A", "B", "C", "D", "A"};
            String[] user2 = {"A", "C", "C", "D", "B"};

            int score1 = QuizProcessor.calculateScore(correctAnswers, user1);
            int score2 = QuizProcessor.calculateScore(correctAnswers, user2);

            userScores.add(score1);
            userScores.add(score2);

            System.out.println("User1 Score: " + score1 + " Grade: "
                    + QuizProcessor.calculateGrade(score1, correctAnswers.length));

            System.out.println("User2 Score: " + score2 + " Grade: "
                    + QuizProcessor.calculateGrade(score2, correctAnswers.length));

            System.out.println("All Scores: " + userScores);

        } catch (InvalidQuizSubmissionException e) {
            System.out.println(e.getMessage());
        }
    }
}