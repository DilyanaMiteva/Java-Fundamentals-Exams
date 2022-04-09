import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "(@|#)(?<word>[A-Za-z]{3,})(\\1{2})(?<reversedWord>[A-Za-z]{3,})(\\1)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        int counter = 0;
        List<String> mirrorWord = new ArrayList<>();
        while (matcher.find()) {
            counter++;
            StringBuilder first = new StringBuilder(String.valueOf(matcher.group("word"))).reverse();
            if (String.valueOf(first).equals(matcher.group("reversedWord"))) {
                mirrorWord.add(String.format("%s <=> %s", matcher.group("word"), matcher.group("reversedWord")));
            }
        }



            if (counter == 0){
                System.out.println("No word pairs found!");
            } else {
                System.out.printf("%d word pairs found!%n", counter);
            }
            if (mirrorWord.isEmpty()){
                System.out.println("No mirror words!");
            } else {
                System.out.println("The mirror words are:");
                for (int i = 0; i < mirrorWord.size(); i++) {
                    System.out.print(mirrorWord.get(i));
                    if (i < mirrorWord.size() - 1){
                        System.out.print(", ");
                    }
                }


            }






    }
}
