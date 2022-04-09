import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String index = scanner.nextLine();
        int turns = 0;

        while (!index.equals("end")) {
            String[] indexInArr = index.split("\\s+");

            int firstIndex = Integer.parseInt(indexInArr[0]);
            int secondIndex = Integer.parseInt(indexInArr[1]);


            for (int i = 0; i < list.size(); i++) {
                if (firstIndex >= 0 && firstIndex < list.size() &&
                        secondIndex >= 0 && secondIndex < list.size() && firstIndex != secondIndex) {

                    if (list.get(firstIndex).equals(list.get(secondIndex))) {
                        System.out.printf("Congrats! You have found matching elements - %s!%n", list.get(firstIndex));
                        list.remove(Math.max(firstIndex, secondIndex));
                        list.remove(Math.min(firstIndex, secondIndex));
                        turns++;
                        i = -1;
                        if (list.isEmpty()){
                            System.out.printf("You have won in %d turns!%n", turns);
                            return;
                        }
                        index = scanner.nextLine();
                        break;


                    } else {
                        System.out.printf("Try again!%n");
                        index = scanner.nextLine();
                        break;
                    }
                } else {
                    System.out.println("Invalid input! Adding additional elements to the board");
                    turns++;
                    for (int j = 0; j < list.size(); j++) {
                        int indexAddInvalid = list.size() / 2 ;
                        String format = "-" + turns + "a";
                        list.add(indexAddInvalid, format);
                        if (list.get(indexAddInvalid).equals(list.get(indexAddInvalid + 1))){
                            index = scanner.nextLine();
                            break;
                        }
                    }
                    break;
                }
            }


            //index = scanner.nextLine();
        }

        System.out.println("Sorry you lose :(");
        for (String s : list) {
            System.out.print(s + " ");
        }

    }
}
