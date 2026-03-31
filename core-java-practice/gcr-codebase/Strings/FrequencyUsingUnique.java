import java.util.Scanner;

public class FrequencyUsingUnique {

    static char[] uniqueCharacters(String text) {
        char[] temp = new char[text.length()];
        int k = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            boolean unique = true;

            for (int j = 0; j < i; j++)
                if (text.charAt(j) == ch)
                    unique = false;

            if (unique)
                temp[k++] = ch;
        }

        char[] result = new char[k];
        for (int i = 0; i < k; i++)
            result[i] = temp[i];

        return result;
    }

    static String[][] frequency(String text) {
        int[] freq = new int[256];
        for (int i = 0; i < text.length(); i++)
            freq[text.charAt(i)]++;

        char[] unique = uniqueCharacters(text);
        String[][] table = new String[unique.length][2];

        for (int i = 0; i < unique.length; i++) {
            table[i][0] = String.valueOf(unique[i]);
            table[i][1] = String.valueOf(freq[unique[i]]);
        }
        return table;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[][] table = frequency(text);
        System.out.println("CHAR\tFREQ");
        for (String[] row : table)
            System.out.println(row[0] + "\t" + row[1]);
    }
}
