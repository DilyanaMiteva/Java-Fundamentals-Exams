import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "(\\||#)(?<item>[A-Za-z\\s]+)\\1(?<date>\\d{2}\\/\\d{2}\\/\\d{2})\\1(?<calories>\\d+)\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        int totalCalories = 0;
        List<String> list = new ArrayList<>();

        while (matcher.find()){
            totalCalories += Integer.parseInt(matcher.group("calories"));
            list.add(String.format("Item: " + matcher.group("item") + ", Best before: "
             + matcher.group("date") + ", Nutrition: " + matcher.group("calories")));
        }
        int possibleDays = totalCalories / 2000;
        System.out.printf("You have food to last you for: %d days!%n", possibleDays);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}
