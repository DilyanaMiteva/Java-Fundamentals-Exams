import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("Eat")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String biscuits = tokens[1];

            switch (command) {
                case "Update-Any":
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).equals(biscuits)) {
                            list.set(i, "Out of stock");
                        }
                    }
                    break;
                case "Remove":
                    int index = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index < list.size()) {
                        list.set(index, biscuits);
                    }
                    break;
                case "Update-Last":
                    for (int i = 0; i < list.size(); i++) {
                        list.remove(list.size() - 1);
                        list.add(biscuits);
                    }

                    break;
                case "Rearrange":
                    if (list.contains(biscuits)) {
                        list.remove(biscuits);
                        list.add(biscuits);
                    }
                    break;
            }
            input = scanner.nextLine();

        }
        for (String s : list) {
            if (!s.equals("Out of stock")) {
                System.out.print(s + " ");
            }
        }


    }
}
