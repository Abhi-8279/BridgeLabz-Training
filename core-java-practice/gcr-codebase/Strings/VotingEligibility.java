public class VotingEligibility {

    static int[] generateAges(int n) {
        int[] ages = new int[n];
        for (int i = 0; i < n; i++)
            ages[i] = (int) (Math.random() * 90);
        return ages;
    }

    static String[][] checkVoting(int[] ages) {
        String[][] table = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            table[i][0] = String.valueOf(ages[i]);
            table[i][1] = (ages[i] >= 18) ? "Can Vote" : "Cannot Vote";
        }
        return table;
    }

    static void display(String[][] table) {
        System.out.println("AGE\tSTATUS");
        for (String[] row : table)
            System.out.println(row[0] + "\t" + row[1]);
    }

    public static void main(String[] args) {
        int[] ages = generateAges(10);
        display(checkVoting(ages));
    }
}

