import java.util.Scanner;

public class SplitCompare {

    static int getLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (RuntimeException e) {
            return count;
        }
    }

    static String[] splitText(String text) {
        int len = getLength(text);
        int words = 1;
        for (int i = 0; i < len; i++)
            if (text.charAt(i) == ' ')
                words++;

        int[] spaces = new int[words + 1];
        spaces[0] = -1;
        int index = 1;

        for (int i = 0; i < len; i++)
            if (text.charAt(i) == ' ')
                spaces[index++] = i;

        spaces[index] = len;

        String[] result = new String[words];
        for (int i = 0; i < words; i++) {
            String word = "";
            for (int j = spaces[i] + 1; j < spaces[i + 1]; j++)
                word += text.charAt(j);
            result[i] = word;
        }
        return result;
    }

    static boolean compareArrays(String[] a, String[] b) {
        if (a.length != b.length)
            return false;
        for (int i = 0; i < a.length; i++)
            if (!a[i].equals(b[i]))
                return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[] custom = splitText(text);
        String[] builtIn = text.split(" ");

        System.out.println("Result matched: " + compareArrays(custom, builtIn));
    }
}

