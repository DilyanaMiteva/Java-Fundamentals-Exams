import java.util.Arrays;
import java.util.Scanner;

public class ActivationKeys_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //String input = scanner.nextLine();
        StringBuilder sb = new StringBuilder(scanner.nextLine());
        String activationKey = scanner.nextLine();


        while (!activationKey.equals("Generate")){
            String[] tokens = activationKey.split(">>>");
            String command = tokens[0];
            switch (command){
                case "Contains":
                    String substring = tokens[1];

                    if (sb.indexOf(substring) >= 0 && sb.indexOf(substring) < sb.length()){
                        System.out.printf("%s contains %s%n", sb, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String upperOrLower = tokens[1];
                    int startIndex = Integer.parseInt(tokens[2]);
                    int endIndex = Integer.parseInt(tokens[3]);
                    if (startIndex >= 0 && startIndex <= sb.length() - 1 &&
                            endIndex >= 0 && endIndex <= sb.length() - 1) {
                        if (upperOrLower.equals("Upper")) {

                            String flippedString = sb.substring(startIndex, endIndex);
                            sb.replace(startIndex, endIndex, flippedString.toUpperCase());
                            System.out.println(sb);


                        } else {

                            String flippedString = sb.substring(startIndex, endIndex);
                            sb.replace(startIndex, endIndex, flippedString.toLowerCase());
                            System.out.println(sb);


                        }
                    }

                    break;
                case "Slice":
                    startIndex = Integer.parseInt(tokens[1]);
                    endIndex = Integer.parseInt(tokens[2]);

                    if (startIndex >= 0 && startIndex <= sb.length() - 1 &&
                            endIndex >= 0 && endIndex <= sb.length() - 1){

                        sb.delete(startIndex, endIndex);
                        System.out.println(sb.toString());

                    }
                    break;
            }

            activationKey = scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s", sb.toString());


    }
}
