
import java.util.*;

public class Numbers_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        String[] input = line.split("\\s+");
        int[] numbers = new int[input.length];

        double sum = 0;

        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
            sum += numbers[i];
        }
        double average = sum / numbers.length;

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            if (average != numbers[i] || numbers.length != 1){
                if (numbers[i] > average){
                    list.add(numbers[i]);
                }
            } else {
                System.out.println("No");
            }
        }

        Collections.sort(list);
        Collections.reverse(list);

        for (int i = 0; i < Math.min(5, list.size()); i++) {
            System.out.print(list.get(i) + " ");
        }


    }
}
