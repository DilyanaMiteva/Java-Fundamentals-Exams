import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AngryPet_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(element -> Integer.parseInt(element)).toArray();

        int entryPoint = Integer.parseInt(scanner.nextLine());
        String typeOfItems = scanner.nextLine();
        String typeOfPriceRating = scanner.nextLine();

        int boundaryElement = Integer.MIN_VALUE;

        int leftSym = 0;
        int rightSym = 0;

        System.out.printf("Left - 22");

    }
}
