import java.util.*;

public class WordTour_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //String input = scanner.nextLine();
        StringBuilder sb = new StringBuilder(scanner.nextLine());
        String line = scanner.nextLine();
        while (!line.equals("Travel")) {
            String[] tokens = line.split(":");
            String command = tokens[0];
            switch (command) {
                case "Add Stop":
                    int index = Integer.parseInt(tokens[1]);
                    String string = tokens[2];

                    if (index >= 0 && index < sb.length()) {
                        sb.insert(index, string);
                    }
                    System.out.println(sb);

                    break;
                case "Remove Stop":
                    int startIndex =Integer.parseInt(tokens[1]);
                    int endIndex =Integer.parseInt(tokens[2]);

                    if (startIndex >= 0 && startIndex < sb.length() &&
                            endIndex >= 0 && endIndex < sb.length()) {
                        sb.replace(startIndex, endIndex + 1, "");
                    }
                    System.out.println(sb);


                    break;
                case "Switch":
                    String oldString = tokens[1];
                    String newString = tokens[2];

                    int startIndexOfOldIndex = sb.indexOf(oldString);
                    int endIndexOfOldIndex = sb.indexOf(oldString) + oldString.length();

                    sb.replace(startIndexOfOldIndex, endIndexOfOldIndex, newString);

                    System.out.println(sb);

                    break;

            }

            line = scanner.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: " + sb);
    }
}
