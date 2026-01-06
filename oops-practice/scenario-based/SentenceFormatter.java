public class SentenceFormatter {
    public static String formatSentence(String input) {

        // Step 1: Trim leading and reduce multiple spaces to one
        input = input.trim().replaceAll("\\s+", " ");

        // Step 2: Ensure one space after punctuation (. ? !)
        input = input.replaceAll("\\s*([.!?])\\s*", "$1 ");

        // Step 3: Capitalize first letter of each sentence
        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = true;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (capitalizeNext && Character.isLetter(ch)) {
                result.append(Character.toUpperCase(ch));
                capitalizeNext = false;
            } else {
                result.append(ch);
            }

            if (ch == '.' || ch == '?' || ch == '!') {
                capitalizeNext = true;
            }
        }

        return result.toString().trim();
    }

 public static void main(String[] args) {
        String input = "  hello   world.this is   java!how are you?  ";
        System.out.println(formatSentence(input));
    }
}
