import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ThePianist_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        Map<String, String[]> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = input.split("\\|");
            String piece = tokens[0];
            String composer = tokens[1];
            String key = tokens[2];
            String[] values = new String[]{composer, key};
            map.put(piece, values);

            input = scanner.nextLine();
        }
        while (!input.equals("Stop")) {
            String[] tokens = input.split("\\|");
            String command = tokens[0];
            String piece = tokens[1];
            switch (command) {
                case "Add":
                    String composer = tokens[2];
                    String key = tokens[3];

                    if (map.containsKey(piece)) {
                        System.out.printf("%s is already in the collection!%n", piece);
                    } else {
                        String[] values = new String[]{composer, key};
                        map.put(piece, values);
                        System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);
                    }
                    break;
                case "Remove":
                    if (map.containsKey(piece)) {
                        map.remove(piece);
                        System.out.printf("Successfully removed %s!%n", piece);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
                case "ChangeKey":
                    String newKey = tokens[2];
                    if (map.containsKey(piece)) {
                        map.get(piece)[1] = newKey;
                        System.out.printf("Changed the key of %s to %s!%n", piece, newKey);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
            }


            input = scanner.nextLine();
        }
        map.entrySet().stream()
                .sorted(Comparator.comparing(k -> k.getValue()[0]))
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.printf("%s -> Composer: %s, Key: %s%n"
                        , e.getKey(), e.getValue()[0], e.getValue()[1]));

    }
}
