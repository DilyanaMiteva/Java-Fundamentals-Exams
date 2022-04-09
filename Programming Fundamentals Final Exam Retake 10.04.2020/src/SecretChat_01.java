import java.util.Scanner;

public class SecretChat_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();
        String operations = scanner.nextLine();

        String copy = "";

        while (!operations.equals("Reveal")){
            String[] tokens = operations.split(":\\|:");
            String command = tokens[0];

            switch (command){
                case "InsertSpace":
                    int index = Integer.parseInt(tokens[1]);
                    String firstPart = message.substring(0, index);
                    String secondPart = message.substring(index);
                    copy = firstPart + " " + secondPart;
                    message = copy;
                    firstPart = "";
                    secondPart = "";
                    System.out.println(message);

                    break;
                case "Reverse":
                    String string = tokens[1];
                    if(message.contains(string)){

                        firstPart = message.substring(0, message.indexOf(string));
                        secondPart = message.substring(message.indexOf(string) + string.length());

                        String reversedSubstring = "";
                        for (int i = string.length() - 1; i >= 0; i--) {
                            reversedSubstring += string.charAt(i);

                        }
                        copy = firstPart + secondPart;
                        copy += reversedSubstring;
                        message = copy;
                        firstPart = "";
                        secondPart = "";

                        System.out.println(message);

                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String substring = tokens[1];
                    String replacement = tokens[2];

                    copy = message.replaceAll(substring, replacement);
                    message = copy;
                    System.out.println(message);


                    break;
            }

            operations = scanner.nextLine();
        }
        System.out.println("You have a new text message: " + message);
    }
}
