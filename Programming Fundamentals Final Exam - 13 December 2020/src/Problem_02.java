import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String regex = "!(?<command>[A-Z][a-z]{2,})!:\\[(?<message>[a-zA-z]{8,})\\]";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            List<Integer> list = new ArrayList<>();
            int ascii = 0;

            if (matcher.find()){
                char[] chars = matcher.group("message").toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    ascii = (int) chars[j];
                    list.add(ascii);

                }

                System.out.print(matcher.group("command") + ": ");
                for (int j = 0; j < list.size(); j++) {
                    System.out.print(list.get(j) + " ");
                }
                System.out.println();
                list = new ArrayList<>();



            } else {

                System.out.println("The message is invalid");
            }
        }
    }
}
