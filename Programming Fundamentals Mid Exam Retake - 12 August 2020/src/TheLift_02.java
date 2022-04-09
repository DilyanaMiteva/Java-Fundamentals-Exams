import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TheLift_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        List<Integer> lift = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        for (int i = 0; i < lift.size(); i++) {
            int possibleCount = 4 - lift.get(i);
            if (lift.get(i) < 4) {
                int toFour = lift.get(i) + possibleCount;

                if (people >= 4) {
                    lift.remove(i);
                    lift.add(i, toFour);
                } else {
                    lift.remove(i);
                    lift.add(i, people);
                    for (Integer integer : lift) {
                        if (integer < 4) {
                            System.out.println("The lift has empty spots!");
                            for (Integer integer1 : lift) {
                                System.out.print(integer1 + " ");
                            }
                            return;
                        }
                    }

                }
                people -= possibleCount;
            }

        }

        if (people > 0) {
            System.out.printf("There isn't enough space! %d people in a queue!%n", people);
            for (Integer integer : lift) {
                System.out.print(integer + " ");
            }
        } else if (people == 0) {
            for (Integer integer : lift) {
                System.out.print(integer + " ");
            }

        }

    }
}
