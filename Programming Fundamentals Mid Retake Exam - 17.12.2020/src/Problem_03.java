import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Shop!")){
            String[] tokens = input.split("%");
            String command = tokens[0];
            String product = tokens[1];
            switch (command){
                case "Important":
                    if (list.contains(product)){
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).equals(product)){
                                list.remove(i);
                                list.add(0, product);
                            }
                        }
                    } else {
                        list.add(0, product);
                    }
                    break;
                case "Add":
                    if (!list.contains(product)){
                        list.add(product);
                    } else {
                        System.out.println("The product is already in the list.");
                    }
                    break;
                case "Swap":
                    String secondProduct = tokens[2];
                    if (list.contains(product) && list.contains(secondProduct)){
                        int indexOfFirstProduct = list.indexOf(product);
                        int indexOfSecondProduct = list.indexOf(secondProduct);

                        list.remove(product);
                        list.remove(secondProduct);
                        list.add(indexOfFirstProduct, secondProduct);
                        list.add(indexOfSecondProduct, product);
                    } else {
                        if (!list.contains(product)) {
                            System.out.println("Product " + product + " missing!");
                        }
                        if (!list.contains(secondProduct)) {
                            System.out.println("Product " + secondProduct + " missing!");
                        }
                    }
                    break;
                case "Remove":
                    if (list.contains(product)){
                        list.remove(product);
                    } else {
                        System.out.printf("Product %s isn't in the list.%n", product);
                    }
                    break;
            }

            input = scanner.nextLine();
        }
        if (!list.isEmpty()){
            for (int i = 0; i < list.size(); i++) {
                System.out.print(i + 1 + ". ");
                System.out.println(list.get(i));
            }
        }

    }
}
