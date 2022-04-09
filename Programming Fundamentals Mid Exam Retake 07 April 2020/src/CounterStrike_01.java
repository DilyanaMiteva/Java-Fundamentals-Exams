import java.util.Scanner;

public class CounterStrike_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        String distance = scanner.nextLine();
        int countOfWin = 0;

        while (!distance.equals("End of battle")) {
            int distanceInt = Integer.parseInt(distance);
            if (energy - distanceInt < 0) {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy%n", countOfWin, energy);
                return;
            }
            countOfWin++;
            energy -= distanceInt;

            if (countOfWin % 3 == 0) {
                energy += countOfWin;
            }
            distance = scanner.nextLine();
        }
        System.out.printf("Won battles: %d. Energy left: %d%n", countOfWin, energy);

    }
}
