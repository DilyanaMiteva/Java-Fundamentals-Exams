import java.util.Arrays;
import java.util.Scanner;

public class ArcheryTournament_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] targets = Arrays.stream(scanner.nextLine().split("\\|"))
                .mapToInt(Integer::parseInt).toArray();

        int sumPoints = 0;

        String input = scanner.nextLine();
        while (!input.equals("Game over")) {
            String[] tokens = input.split("@");
            String command = tokens[0];

            switch (command) {
                case "Shoot Left":
                    int startIndexLeft = Integer.parseInt(tokens[1]);
                    int leftLength = Integer.parseInt(tokens[2]);
                    if (startIndexLeft >= 0 && startIndexLeft < targets.length) {
                        int targetIndex = startIndexLeft - leftLength;
                        while (targetIndex < 0) {
                            targetIndex = targets.length + targetIndex;
                        }
                        if (targets[targetIndex] >= 5) {
                            targets[targetIndex] -= 5;
                            sumPoints += 5;
                        } else {
                            sumPoints += targets[targetIndex];
                            targets[targetIndex] = 0;
                        }
                    }
                    break;
                case "Shoot Right":
                    int startIndexRight = Integer.parseInt(tokens[1]);
                    int rightLength = Integer.parseInt(tokens[2]);
                    if (startIndexRight >= 0 && startIndexRight < targets.length) {
                        int targetIndex = startIndexRight + rightLength;
                        while (targetIndex >= targets.length) {
                            targetIndex = targetIndex - targets.length;
                        }
                        if (targets[targetIndex] >= 5){
                            targets[targetIndex] -= 5;
                            sumPoints += 5;
                        } else {
                            sumPoints += targets[targetIndex];
                            targets[targetIndex] = 0;
                        }
                    }
                    break;
                case "Reverse":
                    int[] reversedNumbers = new int[targets.length];
                    for (int i = 0; i < targets.length / 2; i++) {
                        int currentNumber = targets[i];
                        targets[i] = targets[targets.length - 1 - i];
                        targets[targets.length - 1 - i] = currentNumber;
                    }
                    break;

            }


            input = scanner.nextLine();
        }
        for (int i = 0; i < targets.length - 1; i++) {
            System.out.print(targets[i] + " - ");
        }
        System.out.println(targets[targets.length - 1]);
        System.out.printf("Iskren finished the archery tournament with %d points!", sumPoints);
    }
}
