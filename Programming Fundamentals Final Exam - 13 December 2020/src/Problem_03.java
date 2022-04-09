import java.util.*;

public class Problem_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, int[]> map = new TreeMap<>();

        int capacity = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();
        while (!line.equals("Statistics")) {
            String[] tokens = line.split("=");
            String command = tokens[0];
            switch (command) {
                case "Add":
                    String username = tokens[1];
                    int sent = Integer.parseInt(tokens[2]);
                    int received = Integer.parseInt(tokens[3]);
                    if (!map.containsKey(username)) {
                        int[] values = new int[]{sent, received};
                        map.put(username, values);
                    }

                    break;
                case "Message":
                    String sender = tokens[1];
                    String receiver = tokens[2];
                    if (map.containsKey(sender) && map.containsKey(receiver)) {
                        map.get(sender)[0] += 1 ;
                        map.get(receiver)[1] += 1;
                        if (map.get(sender)[0] + map.get(sender)[1] >= capacity) {
                            map.remove(sender);
                            System.out.println(sender + " reached the capacity!");
                        }
                        if (map.get(receiver)[0] + map.get(receiver)[1] >= capacity) {
                            map.remove(receiver);
                            System.out.println(receiver + " reached the capacity!");
                        }
                    }


                    break;
                case "Empty":
                    String usernames = tokens[1];
                    if (usernames.equals("All")) {
                        map.clear();
                        break;
                    }


                        if (map.containsKey(usernames)) {
                            map.remove(usernames);
                        }


                    break;
            }

            line = scanner.nextLine();
        }
        System.out.println("Users count: " + map.size());

        map.entrySet().stream()
                .sorted((a,b) -> Integer.compare(b.getValue()[1], a.getValue()[1]))

                .forEach(e -> System.out.printf("%s - %d%n", e.getKey(), Arrays.stream(e.getValue()).sum()));
    }
}
