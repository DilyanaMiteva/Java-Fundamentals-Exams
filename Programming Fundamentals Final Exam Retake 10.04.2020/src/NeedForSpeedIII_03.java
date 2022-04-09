import jdk.jshell.execution.Util;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class NeedForSpeedIII_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        Map<String, int[]> allCars = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = input.split("\\|");
            String car = tokens[0];
            int mileage = Integer.parseInt(tokens[1]);
            int fuel = Integer.parseInt(tokens[2]);
            int[] mileageAndFuel = new int[]{mileage, fuel};
            allCars.put(car, mileageAndFuel);

            input = scanner.nextLine();
        }

        while (!input.equals("Stop")) {
            String[] tokens = input.split(" : ");
            String command = tokens[0];
            String car = tokens[1];
            switch (command) {
                case "Drive":
                    int distance = Integer.parseInt(tokens[2]);
                    int fuel = Integer.parseInt(tokens[3]);

                    if (fuel > allCars.get(car)[1]) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        allCars.get(car)[0] = allCars.get(car)[0] + distance;
                        allCars.get(car)[1] = allCars.get(car)[1] - fuel;
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n"
                                , car, distance, fuel);
                    }
                    if (allCars.get(car)[0] >= 100000) {
                        allCars.remove(car);
                        System.out.printf("Time to sell the %s!%n", car);
                    }
                    break;
                case "Refuel":
                    fuel = Integer.parseInt(tokens[2]);

                    if (allCars.get(car)[1] + fuel > 75) {
                        int newFuel = 75 - allCars.get(car)[1];
                        allCars.get(car)[1] = allCars.get(car)[1] + newFuel;
                        System.out.println(car + " refueled with " + newFuel + " liters");

                    } else {
                        allCars.get(car)[1] = allCars.get(car)[1] + fuel;
                        System.out.println(car + " refueled with " + fuel + " liters");
                    }

                    break;
                case "Revert":
                    int kilometers = Integer.parseInt(tokens[2]);
                    if (kilometers < allCars.get(car)[0]) {
                        allCars.get(car)[0] = allCars.get(car)[0] - kilometers;
                        if (allCars.get(car)[0] < 10000) {
                            allCars.get(car)[0] = 10000;
                            break;
                        }
                        System.out.printf("%s mileage decreased by %d kilometers%n"
                                , car, kilometers);
                    }

                    break;
            }

            input = scanner.nextLine();
        }
        allCars.entrySet().stream().sorted((a, b) -> Integer.compare(b.getValue()[0], a.getValue()[0]))
                .forEach(e -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n"
                        , e.getKey(), e.getValue()[0], e.getValue()[1]));

    }
}
