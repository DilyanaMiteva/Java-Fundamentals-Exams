import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String emojiRegex = "(?<name>([*]{2})[A-Z][a-z]{2,}([*]{2})|([:]{2})[A-Z][a-z]{2,}([:]{2}))";
        Pattern emojiPattern = Pattern.compile(emojiRegex);
        Matcher emojiMatcher = emojiPattern.matcher(text);

        long allCoolThreshold = 1;
        String coolRegex = "\\d";
        Pattern coolPattern = Pattern.compile(coolRegex);
        Matcher coolMatcher = coolPattern.matcher(text);

        List<String> emoji = new ArrayList<>();

        int emojiCoolThreshold = 0;
        int counter = 0;

        while (coolMatcher.find()) {
            allCoolThreshold *= Integer.parseInt(coolMatcher.group());
        }
        while (emojiMatcher.find()) {

            for (int i = 2; i < emojiMatcher.group().length() - 2; i++) {
                emojiCoolThreshold += emojiMatcher.group().charAt(i);
            }
            counter++;

            if (emojiCoolThreshold > allCoolThreshold) {
                emoji.add(emojiMatcher.group());
            }
            emojiCoolThreshold = 0;

        }


        System.out.println("Cool threshold: " + allCoolThreshold);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", counter);

        for (String s : emoji) {
            System.out.println(s);
        }


    }
}
