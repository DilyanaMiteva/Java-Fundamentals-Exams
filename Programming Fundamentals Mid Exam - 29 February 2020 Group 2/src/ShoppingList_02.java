import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = Arrays.stream(scanner.nextLine().split("!"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Go Shopping!")){

            String[] commandAsArray = input.split(" ");
            String command = commandAsArray[0];
            String item = commandAsArray[1];

            switch (command){
                case "Urgent":
                    if (!list.contains(item)){
                        list.add(0, item);
                    }
                    break;
                case "Unnecessary":
                    if (list.contains(item)){
                        list.remove(item);
                    }
                    break;
                case "Correct":
                    String newItem = commandAsArray[2];
                    if (list.contains(item)){
                        int index = list.indexOf(item);
                        list.remove(item);
                        list.add(index, newItem);
                    }
                    break;
                case "Rearrange":
                    if (list.contains(item)){
                        list.remove(item);
                        list.add(item);
                    }
                    break;

            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < list.size(); i++) {
            if (i != list.size() - 1) {
                System.out.print(list.get(i) + ", ");
            } else {
                System.out.print(list.get(i));
            }
        }

    }
}
