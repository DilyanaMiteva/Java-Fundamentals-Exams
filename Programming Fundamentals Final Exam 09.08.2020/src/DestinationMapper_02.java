import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "(=|\\/)(?<place>[A-Z][A-Za-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(input);
        List<String> places = new ArrayList<>();

        int travelPoints = 0;
        while (matcher.find()){
            places.add(matcher.group("place"));
            travelPoints += matcher.group("place").length();
        }
        System.out.print("Destinations: ");
        for (int i = 0; i < places.size(); i++) {
            System.out.print(places.get(i));
            if (i < places.size() - 1){
                System.out.print(", ");
            }
        }
        System.out.println();
        System.out.println("Travel Points: " + travelPoints);
    }
}
