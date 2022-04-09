import java.util.*;

public class Pirates_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, int[]> cities = new TreeMap<>();

        String line = scanner.nextLine();

        while (!line.equals("Sail")) {
            String[] tokens = line.split("\\|\\|");
            String city = tokens[0];
            int population = Integer.parseInt(tokens[1].trim());
            int gold = Integer.parseInt(tokens[2].trim());
            int[] populationAndGold = new int[]{population, gold};

            if (cities.containsKey(city)) {
                int newValueOfPopulation = cities.get(city)[0] + population;
                cities.get(city)[0] = newValueOfPopulation;
                int newValueOfGold = cities.get(city)[1] + gold;
                cities.get(city)[1] = newValueOfGold;
            } else {
                cities.put(city, populationAndGold);
            }

            line = scanner.nextLine();
        }


        line = scanner.nextLine();

        while (!line.equals("End")) {
            String[] tokens2 = line.split("=>");
            String command = tokens2[0];
            String town = tokens2[1];
            switch (command) {
                case "Plunder":
                    int people = Integer.parseInt(tokens2[2].trim());
                    int gold = Integer.parseInt(tokens2[3].trim());


                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n"
                            , town, gold, people);
                    int newPopulation = cities.get(town)[0] - people;
                    int newGold = cities.get(town)[1] - gold;
                    cities.get(town)[0] = newPopulation;
                    cities.get(town)[1] = newGold;
                    //newPopulation = 0;
                    //newGold = 0;

                    if (cities.containsKey(town)) {
                        if (cities.get(town)[0] <= 0) {
                            cities.remove(town);
                            System.out.println(town + " has been wiped off the map!");
                        }
                    }
                    if (cities.containsKey(town)) {
                        if (cities.get(town)[1] <= 0) {
                            cities.remove(town);
                            System.out.println(town + " has been wiped off the map!");
                        }
                    }

                    break;
                case "Prosper":
                    gold = Integer.parseInt(tokens2[2]);

                    Integer currentGold = cities.get(town)[1];
                    if (currentGold == null) {
                        currentGold = 0;
                    }


                    if (gold >= 0) {
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n"
                                , gold, town, currentGold + gold);
                        newGold = cities.get(town)[1] + gold;
                        cities.get(town)[1] = newGold;
                    } else {
                        System.out.println("Gold added cannot be a negative number!");
                    }



                    break;
            }

            line = scanner.nextLine();
        }
        if (cities.isEmpty()){
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n"
                    , cities.size());
        }

        cities.entrySet().stream()
                .sorted((a,b) -> Integer.compare(b.getValue()[1], a.getValue()[1]))
                .forEach(e -> System.out.println(String.format(e.getKey()
                        + " -> Population: "
                        + e.getValue()[0]
                        + " citizens, Gold: "
                        + e.getValue()[1] + " kg")));


    }
}
