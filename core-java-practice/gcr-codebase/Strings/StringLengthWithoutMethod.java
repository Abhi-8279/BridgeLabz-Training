import java.util.Scanner;

public class StringLengthWithoutMethod {

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.next();

        System.out.println("Length (User Defined): " + getLength(text));
        System.out.println("Length (Built-in): " + text.length());
    }
}

