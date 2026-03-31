public class TextAnalyzer {
    public static void analyzeText(String paragraph,String wordToReplace,String replacementWord){
         if (paragraph == null || paragraph.trim().isEmpty()) {
            System.out.println("Paragraph is empty or contains only spaces.");
            return;
        }

        String cleanText= paragraph.trim().replace("\\s+", " ");

        String []words= cleanText.split("[^a-zA-Z]+");

         int wordCount = words.length;

         // Find longest word
        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        //  Replace word (case-insensitive)
        String replacedText = cleanText.replaceAll(
                "(?i)\\b" + wordToReplace + "\\b",
                replacementWord
        );

        
        System.out.println("Word Count: " + wordCount);
        System.out.println("Longest Word: " + longestWord);
        System.out.println("Updated Paragraph: " + replacedText);

    }
    public static void main(String[] args) {
          String paragraph = "Java is powerful. Java is widely used in enterprise applications.";
        analyzeText(paragraph, "java", "Python");
    }
}
