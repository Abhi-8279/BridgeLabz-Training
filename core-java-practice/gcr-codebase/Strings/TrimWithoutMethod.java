import java.util.Scanner;

public class TrimWithoutMethod {

    static int[] trimIndex(String text) {
        int start = 0, end = text.length() - 1;

        while (text.charAt(start) == ' ') start++;
        while (text.charAt(end) == ' ') end--;

        return new int[]{start, end + 1};
    }

    static String substring(String text, int s, int e) {
        String res = "";
        for (int i = s; i < e; i++)
            res += text.charAt(i);
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        int[] idx = trimIndex(text);
        String custom = substring(text, idx[0], idx[1]);
        String builtIn = text.trim();

        System.out.println("Result matched: " + custom.equals(builtIn));
    }
}


