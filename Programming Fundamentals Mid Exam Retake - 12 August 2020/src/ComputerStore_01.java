import java.util.Scanner;

public class ComputerStore_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double totalPrice = 0;

        while (!(input.equals("special") || input.equals("regular"))) {
            double price = Double.parseDouble(input);
            if (price > 0) {
                totalPrice += price;
            } else {
                System.out.printf("Invalid price!%n");
            }

            input = scanner.nextLine();
        }

        double taxes = totalPrice * 0.2;
        double totalPriceWithTaxes = totalPrice + taxes;
        if (input.equals("special")){
            totalPriceWithTaxes = totalPriceWithTaxes - (totalPriceWithTaxes * 0.1);
        }
        if (totalPrice == 0 || taxes == 0){
            System.out.println("Invalid order!");
            return;
        }
        System.out.printf("Congratulations you've just bought a new computer!%n");
        System.out.printf("Price without taxes: %.2f$%n", totalPrice);
        System.out.printf("Taxes: %.2f$%n",taxes);
        System.out.printf("-----------%n");
        System.out.printf("Total price: %.2f$%n", totalPriceWithTaxes);

    }
}
