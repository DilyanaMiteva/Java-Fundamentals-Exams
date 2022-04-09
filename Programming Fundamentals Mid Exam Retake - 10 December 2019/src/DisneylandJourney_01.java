import java.util.Scanner;

public class DisneylandJourney_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int journeyCost = Integer.parseInt(scanner.nextLine());
        int months = Integer.parseInt(scanner.nextLine());
        double savedForAMonth = 0;

        for (int i = 1; i <= months; i++) {
            if (i % 2 == 1 && i != 1) {
                savedForAMonth -= savedForAMonth * 0.16;
            }
            if (i % 4 == 0) {
                savedForAMonth += savedForAMonth * 0.25;
            }
            savedForAMonth = savedForAMonth + (journeyCost * 0.25);

        }
        if (savedForAMonth > journeyCost) {
            System.out.printf("Bravo! You can go to Disneyland " +
                    "and you will have %.2flv. for souvenirs.", savedForAMonth - journeyCost);
        } else {
            System.out.printf("Sorry. You need %.2flv. " +
                    "more.", -(savedForAMonth - journeyCost));
        }
    }
}
