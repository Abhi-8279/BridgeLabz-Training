import java.util.Scanner;

public class PalindromeCheck {

    static boolean isPalindromeIterative(String text) {
        int start = 0, end = text.length() - 1;
        while (start < end) {
            if (text.charAt(start) != text.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end)
            return true;
        if (text.charAt(start) != text.charAt(end))
            return false;
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    static char[] reverse(String text) {
        char[] rev = new char[text.length()];
        int k = 0;
        for (int i = text.length() - 1; i >= 0; i--)
            rev[k++] = text.charAt(i);
        return rev;
    }

    static boolean isPalindromeArray(String text) {
        char[] original = text.toCharArray();
        char[] rev = reverse(text);

        for (int i = 0; i < original.length; i++)
            if (original[i] != rev[i])
                return false;

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.println("Iterative: " + isPalindromeIterative(text));
        System.out.println("Recursive: " +
                isPalindromeRecursive(text, 0, text.length() - 1));
        System.out.println("Array Logic: " + isPalindromeArray(text));
    }
}

