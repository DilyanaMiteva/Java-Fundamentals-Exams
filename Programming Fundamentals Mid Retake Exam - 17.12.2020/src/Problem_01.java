import java.util.Scanner;

public class Problem_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        double flourPricePerPack = Double.parseDouble(scanner.nextLine());

        double eggPricePerOne = 0.75 * flourPricePerPack;
        double milkPriceOneLiter = 0.25 * flourPricePerPack + flourPricePerPack;

        double totalPriceForOneCozonac = flourPricePerPack + eggPricePerOne + milkPriceOneLiter / 4;
        int countCozonacs = 0;
        int colorfulEgs = 0;

        while (budget >= totalPriceForOneCozonac) {
            budget -= totalPriceForOneCozonac;
            countCozonacs++;
            colorfulEgs += 3;

            if (countCozonacs % 3 == 0){
                colorfulEgs -= countCozonacs - 2;
            }
        }
        System.out.printf("You made %d cozonacs! Now you have %d eggs and %.2fBGN left."
                , countCozonacs, colorfulEgs, budget);

    }
}
