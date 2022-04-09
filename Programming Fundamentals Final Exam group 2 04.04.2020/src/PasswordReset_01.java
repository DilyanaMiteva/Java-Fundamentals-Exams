import java.util.Scanner;

public class PasswordReset_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();

        String lineCommand = scanner.nextLine();


        while (!lineCommand.equals("Done")) {

            String[] tokens = lineCommand.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "TakeOdd":
                    String temporary = "";
                    for (int i = 1; i < string.length(); i += 2) {
                        temporary += string.charAt(i);
                    }
                    string = temporary;
                    System.out.println(string);
                    break;
                case "Cut":
                    int index = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);

                    String firstPart = string.substring(0, index);
                    String secondPart = string.substring(index + length);

                    string = firstPart + secondPart;
                    System.out.println(string);

                    break;
                case "Substitute":
                    String fromChar = tokens[1];
                    String toChar = tokens[2];

                    temporary = "";

                    if (string.contains(fromChar)){
                        temporary = string.replace(fromChar, toChar);
                        string = temporary;
                        System.out.println(string);
                    } else {
                        System.out.println("Nothing to replace!");
                    }

                    break;
            }

            lineCommand = scanner.nextLine();

        }
        System.out.println("Your password is: " + string);
    }
}
