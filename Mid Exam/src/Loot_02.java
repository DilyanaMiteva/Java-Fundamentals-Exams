import java.util.*;
import java.util.stream.Collectors;

public class Loot_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());

        List<String> stealElement = new ArrayList<>();
        String input = scanner.nextLine();

        double averageProfit = 0.0;

        while (!input.equals("Yohoho!")) {
            String[] token = input.split(" ");
            String command = token[0];
            switch (command) {
                case "Loot":
                    for (int i = 1; i < token.length; i++) {
                        String item = token[i];
                        if (!list.contains(item)) {
                            list.add(0, item);
                        }
                    }
                    break;

                case "Drop":
                    int index = Integer.parseInt(token[1]);
                    if (index >= 0 && index < list.size()) {
                        String item = list.get(index);
                        list.remove(index);
                        list.add(item);
                    }
                    break;
                case "Steal":
                    int countOfRemoved = Integer.parseInt(token[1]);
                    for (int i = 1; i <= countOfRemoved; i++) {

                        stealElement.add(list.get(list.size() - 1));
                        list.remove(list.get(list.size() - 1));
                        if (list.isEmpty()){
                            break;
                        }

                    }
                    Collections.reverse(stealElement);
                    for (int i = 0; i < stealElement.size(); i++) {
                        System.out.print(stealElement.get(i));
                        if (i < stealElement.size() - 1) {
                            System.out.print(", ");
                        }
                    }
                    System.out.println();

                    break;
            }

            input = scanner.nextLine();
        }

        int countSymbol = 0;
        for (String s : list) {
            String[] chars = s.split("");
            for (int i = 0; i < chars.length; i++) {
                countSymbol++;
            }
        }
        if (!list.isEmpty()) {
            averageProfit = (double) countSymbol / list.size();
            System.out.printf("Average treasure gain: %.2f pirate credits.", averageProfit);
        } else {
            System.out.println("Failed treasure hunt.");
        }

    }
}
