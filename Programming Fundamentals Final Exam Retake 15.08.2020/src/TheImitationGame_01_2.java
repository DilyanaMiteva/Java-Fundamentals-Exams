import java.util.Scanner;

public class TheImitationGame_01_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();
        String line = scanner.nextLine();

        String copyMessage = "";

        while (!line.equals("Decode")){
            String[] tokens = line.split("\\|");
            String command = tokens[0];
            switch (command){
                case "Move":
                    int numberOfLetter = Integer.parseInt(tokens[1]);
                    String movePart = message.substring(0, numberOfLetter);
                    String stringWithoutMovePart = message.substring(numberOfLetter);
                    copyMessage = stringWithoutMovePart + movePart;
                    message = copyMessage;

                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[1]);
                    String value = tokens[2];
                    /*String firstPart = message.substring(0, index);
                    String secondPart = message.substring(index);
                    copyMessage = firstPart + value + secondPart;
                    message = copyMessage;*/
                    StringBuilder sb = new StringBuilder();
                    sb.append(message);
                    sb.insert(index, value);
                    message = sb.toString();
                    break;
                case "ChangeAll":
                    String substring = tokens[1];
                    String replacement = tokens[2];

                    copyMessage = message.replace(substring, replacement);
                    message = copyMessage;

                    break;
            }

            line = scanner.nextLine();
        }

        System.out.println("The decrypted message is: " + message);    }
}
