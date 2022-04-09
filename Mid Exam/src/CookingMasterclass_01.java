import java.util.Scanner;

public class CookingMasterclass_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double flourPricePerPack = Double.parseDouble(scanner.nextLine());
        double eggPricePerOne = Double.parseDouble(scanner.nextLine());
        double apronPricePerOne = Double.parseDouble(scanner.nextLine());
        double apronSum = (apronPricePerOne * students) + (Math.ceil(students * 0.2) * apronPricePerOne);
        double eggSum = students * 10 * eggPricePerOne;
        double flourSum = 0;
        for (int i = 1; i <= students; i++) {
            if (i % 5 != 0) {
                flourSum += flourPricePerPack;
            }
        }
        double total = eggSum + flourSum + apronSum;
        if (total <= budget) {
            System.out.printf("Items purchased for %.2f$.\n", total);
        } else {
            System.out.printf("%.2f$ more needed.\n", total - budget);
        }
    }
}
