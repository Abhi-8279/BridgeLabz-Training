import java.util.Scanner;

public class UniqueCharacters {

    static int getLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count++);
            }
        } catch (RuntimeException e) {
            return count - 1;
        }
    }

    static char[] uniqueCharacters(String text) {
        int len = getLength(text);
        char[] temp = new char[len];
        int k = 0;

        for (int i = 0; i < len; i++) {
            char ch = text.charAt(i);
            boolean isUnique = true;

            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == ch) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique)
                temp[k++] = ch;
        }

        char[] result = new char[k];
        for (int i = 0; i < k; i++)
            result[i] = temp[i];

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        char[] unique = uniqueCharacters(text);
        System.out.print("Unique Characters: ");
        for (char c : unique)
            System.out.print(c + " ");
    }
}

