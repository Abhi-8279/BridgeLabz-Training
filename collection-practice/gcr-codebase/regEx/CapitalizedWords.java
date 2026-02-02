import java.util.*;
import java.util.regex.*;

public class CapitalizedWords {

    public static void main(String[] args) {

        String sentence =
            "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";

        Pattern pattern = Pattern.compile("\\b[A-Z][a-z]*\\b");
        Matcher matcher = pattern.matcher(sentence);

        List<String> words = new ArrayList<>();

        while (matcher.find()) {
            words.add(matcher.group());
        }

        System.out.println(String.join(", ", words));
    }
}
