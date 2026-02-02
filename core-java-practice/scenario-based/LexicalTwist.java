import java.util.Scanner;

public class LexicalTwist {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter the first word");
        String word1 = in.nextLine();

        if (word1.contains(" ")) {
            System.out.println(word1 + " is an invalid word");
            return;
        }

        System.out.println("Enter the second word");
        String word2 = in.nextLine();

        String w1 = word1.toLowerCase();
        String w2 = word2.toLowerCase();

        String rev = new StringBuilder(w1).reverse().toString();

        if (rev.equals(w2)) {
            String result = rev.replaceAll("[aeiou]", "@");
            System.out.println(result);
        } else {
            String fin = (word1 + word2).toUpperCase();

            int vowels = countVowels(fin);
            int consonants = countConsonants(fin);

            if (vowels > consonants) {
                print2UniqueVowels(fin);
            } else if (consonants > vowels) {
                print2UniqueConsonants(fin);
            } else {
                System.out.println("Vowels and consonants are equal");
            }
        }

        in.close();
    }

    private static int countVowels(String s) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if ("AEIOU".indexOf(ch) != -1) count++;
        }
        return count;
    }

    private static int countConsonants(String s) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z' && "AEIOU".indexOf(ch) == -1) count++;
        }
        return count;
    }

    private static void print2UniqueVowels(String s) {
        String out = "";
        for (char ch : s.toCharArray()) {
            if ("AEIOU".indexOf(ch) != -1 && out.indexOf(ch) == -1) {
                out += ch;
            }
            if (out.length() == 2) break;
        }
        System.out.println(out);
    }

    private static void print2UniqueConsonants(String s) {
        String out = "";
        for (char ch : s.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z' &&
                "AEIOU".indexOf(ch) == -1 &&
                out.indexOf(ch) == -1) {
                out += ch;
            }
            if (out.length() == 2) break;
        }
        System.out.println(out);
    }
}