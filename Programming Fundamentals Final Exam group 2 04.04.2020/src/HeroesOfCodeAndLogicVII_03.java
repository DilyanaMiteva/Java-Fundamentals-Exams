import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HeroesOfCodeAndLogicVII_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, int[]> heroAndPoints = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String[] tokens = line.split("\\s+");
            String name = tokens[0];
            int hp = Integer.parseInt(tokens[1]);
            int mp = Integer.parseInt(tokens[2]);
            int[] points = new int[]{hp, mp};
            heroAndPoints.put(name, points);
            line = scanner.nextLine();
        }
        //String input = scanner.nextLine();
        while (!line.equals("End")) {
            String[] tokens = line.split(" - ");
            String command = tokens[0];
            String name = tokens[1];
            switch (command) {
                case "CastSpell":
                    int mp = Integer.parseInt(tokens[2]);
                    String spell = tokens[3];
                    if (heroAndPoints.get(name)[1] >= mp) {
                        heroAndPoints.get(name)[1] = heroAndPoints.get(name)[1] - mp;
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n"
                                , name, spell, heroAndPoints.get(name)[1]);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n",
                                name, spell);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(tokens[2]);
                    String attacker = tokens[3];


                    if (heroAndPoints.get(name)[0] - damage > 0) {
                        heroAndPoints.get(name)[0] = heroAndPoints.get(name)[0] - damage;
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n"
                                , name, damage, attacker, heroAndPoints.get(name)[0]);
                    } else {
                        System.out.printf("%s has been killed by %s!%n"
                                , name, attacker);
                        heroAndPoints.remove(name);
                    }
                    break;
                case "Recharge":
                    int amount = Integer.parseInt(tokens[2]);
                    if (heroAndPoints.get(name)[1] + amount > 200){
                        int maxPointsTo200 = 200 - heroAndPoints.get(name)[1];
                        System.out.printf("%s recharged for %d MP!%n"
                        , name, maxPointsTo200);
                        heroAndPoints.get(name)[1] = heroAndPoints.get(name)[1] + maxPointsTo200;
                    } else {
                        heroAndPoints.get(name)[1] = heroAndPoints.get(name)[1] + amount;
                        System.out.printf("%s recharged for %d MP!%n"
                                , name, amount);
                    }
                    break;
                case "Heal":
                    amount = Integer.parseInt(tokens[2]);
                    if (heroAndPoints.get(name)[0] + amount > 100){
                        int maxPointsTo100 = 100 - heroAndPoints.get(name)[0];
                        System.out.printf("%s healed for %d HP!%n"
                                , name, maxPointsTo100);
                        heroAndPoints.get(name)[0] = heroAndPoints.get(name)[0] + maxPointsTo100;

                    } else {
                        heroAndPoints.get(name)[0] = heroAndPoints.get(name)[0] + amount;
                        System.out.printf("%s healed for %d HP!%n"
                                , name, amount);
                    }
                    break;
            }
            line = scanner.nextLine();
        }
        heroAndPoints.entrySet().stream()
                .sorted((a,b) -> Integer.compare(b.getValue()[0], a.getValue()[0]))
                .forEach(e -> System.out.printf("%s%nHP: %d%nMP: %d%n"
                        , e.getKey(), e.getValue()[0], e.getValue()[1]));

    }
}
