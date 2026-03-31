import java.util.Scanner;

public class VowelconsonantCount {

    static String checkChar(char ch) {
        if (ch >= 'A' && ch <= 'Z')
            ch = (char) (ch + 32);

        if (ch >= 'a' && ch <= 'z') {
            if ("aeiou".indexOf(ch) >= 0)
                return "Vowel";
            else
                return "Consonant";
        }
        return "Not a Letter";
    }

    static int[] countVC(String text) {
        int v = 0, c = 0;
        for (int i = 0; i < text.length(); i++) {
            String type = checkChar(text.charAt(i));
            if (type.equals("Vowel")) v++;
            if (type.equals("Consonant")) c++;
        }
        return new int[]{v, c};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        int[] result = countVC(text);
        System.out.println("Vowels: " + result[0]);
        System.out.println("Consonants: " + result[1]);
    }
}

