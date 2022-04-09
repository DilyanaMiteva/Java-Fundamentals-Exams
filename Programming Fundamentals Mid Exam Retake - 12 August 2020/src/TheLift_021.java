import java.util.Arrays;
import java.util.Scanner;

public class TheLift_021 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        int[] lift = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < lift.length; i++) {
            int possibleCount = 4 - lift[i];
            lift[i] += possibleCount;
            people -= possibleCount;

            if (people < 4 && people > 0){
                lift[i + 1] = people;
                System.out.println("The lift has empty spots!");
                for (int elevatorCar : lift) {
                    System.out.print(elevatorCar + " ");
                }
                return;
            }
        }
        if (people == 0){
            for (int elevatorCar : lift) {
                System.out.print(elevatorCar + " ");

            }
            return;
        }
        System.out.printf("There isn't enough space! %d people in a queue!%n", people);
        for (int elevatorCar : lift) {
            System.out.print(elevatorCar + " ");

        }
    }
}
