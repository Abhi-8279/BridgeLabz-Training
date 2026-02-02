import java.util.Scanner;
import java.util.regex.Pattern;

public class Program {

    public String CleanseAndInvert(String input) {
        // 1. Input must not be null and at least 6 characters long
        if (input == null || input.length() < 6) {
            return "";
        }

        if (Pattern.compile("[^a-zA-Z]").matcher(input).find()) {
            return "";
        }

        // Convert to lowercase.
        String lowerCaseInput = input.toLowerCase();
        
        StringBuilder oddAsciiChars = new StringBuilder();

        // Remove all characters whose ASCII values are even numbers
        for (char c : lowerCaseInput.toCharArray()) {
            // Check if ASCII value is odd.
            if (((int) c) % 2 != 0) {
                oddAsciiChars.append(c);
            }
        }

        // Reverse the remaining characters.
        String reversedString = oddAsciiChars.reverse().toString();

        StringBuilder finalKey = new StringBuilder();

        // Convert characters at even positions (0-based index) to uppercase.
        for (int i = 0; i < reversedString.length(); i++) {
            char c = reversedString.charAt(i);
            
            // Even positioned character (0 based index)
            if (i % 2 == 0) {
                finalKey.append(Character.toUpperCase(c));
            } else {
                finalKey.append(c);
            }
        }

        // Return the generated key
        return finalKey.toString();
    }


    public static void main(String[] args) {
        Program program = new Program();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the word");
        String userInput = sc.nextLine();
        
        String generatedKey = program.CleanseAndInvert(userInput);

        if (generatedKey.isEmpty()) {

            System.out.println("Invalid Input");
        } else {

            System.out.println("The generated key is - " + generatedKey);
        }
        
        sc.close();
    }
}