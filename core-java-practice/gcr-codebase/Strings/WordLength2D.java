import java.util.Scanner;

public class WordLength2D {

    static int getLength(String text) {
        int c = 0;
        try {
            while (true) {
                text.charAt(c++);
            }
        } catch (RuntimeException e) {
            return c - 1;
        }
    }

    static String[] splitText(String text) {
        int words = 1;
        for (int i = 0; i < getLength(text); i++)
            if (text.charAt(i) == ' ')
                words++;

        String[] arr = new String[words];
        int idx = 0;
        String word = "";

        for (int i = 0; i < getLength(text); i++) {
            if (text.charAt(i) == ' ') {
                arr[idx++] = word;
                word = "";
            } else
                word += text.charAt(i);
        }
        arr[idx] = word;
        return arr;
    }

    static String[][] wordLengthTable(String[] words) {
        String[][] table = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            table[i][0] = words[i];
            table[i][1] = String.valueOf(getLength(words[i]));
        }
        return table;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[] words = splitText(text);
        String[][] table = wordLengthTable(words);

        System.out.println("WORD\tLENGTH");
        for (String[] row : table)
            System.out.println(row[0] + "\t" + Integer.parseInt(row[1]));
    }
}
