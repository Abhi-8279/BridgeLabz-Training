class EduQuiz {

    static int calculateScore(String[] correct, String[] student) {
        int score = 0;

        for (int i = 0; i < correct.length; i++) {
            if (correct[i].equalsIgnoreCase(student[i])) {
                score++;
                System.out.println("Question " + (i + 1) + ": Correct");
            } else {
                System.out.println("Question " + (i + 1) + ": Incorrect");
            }
        }
        return score;
    }

    public static void main(String[] args) {

        String[] correctAnswers = {
            "A", "B", "C", "D", "A",
            "C", "B", "D", "A", "B"
        };

        String[] studentAnswers = {
            "A", "b", "C", "A", "A",
            "C", "b", "D", "C", "B"
        };

        int score = calculateScore(correctAnswers, studentAnswers);
        double percentage = (score / 10.0) * 100;

        System.out.println("\nScore: " + score + "/10");
        System.out.println("Percentage: " + percentage + "%");

        if (percentage >= 50) {
            System.out.println("Result: PASS");
        } else {
            System.out.println("Result: FAIL");
        }
    }
}
