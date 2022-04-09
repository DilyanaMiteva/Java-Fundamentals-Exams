import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ShootForTheWin_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        String input = scanner.nextLine();
        int countOfShotTargets = 0;

        while (!input.equals("End")) {
            int indexTarget = Integer.parseInt(input);

            if (indexTarget >= 0 && indexTarget < array.length)
            {
                for (int i = 0; i < array.length; i++)
                {
                    int temp = array[indexTarget];

                    if (array[i] != -1 && i != indexTarget)
                    {
                        if(array[i] > temp)
                        {
                            array[i] -= temp;
                        }
                        else if (array[i] <= temp)
                        {
                            array[i] += temp;

                        }
                    }
                }
                array[indexTarget] = -1;
                countOfShotTargets++;
            }
            input = scanner.nextLine();
        }
            System.out.printf("Shot targets: %d -> ", countOfShotTargets);
            System.out.print(Arrays.toString(array).replaceAll("[\\[\\]]", "").replaceAll(", ", " "));

    }
}
