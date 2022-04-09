import java.util.Scanner;

public class TheImitationGame_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder(scanner.nextLine());
        String line = scanner.nextLine();
        while (!line.equals("Decode")){
            String[] tokens = line.split("\\|");
            String command = tokens[0];
            switch (command){
                case "Move":
                    int numberOfLetter = Integer.parseInt(tokens[1]);
                    char stopChar = sb.charAt(numberOfLetter - 1);
                    for (int i = 0; i < numberOfLetter; i++) {
                        char firstChar = sb.charAt(i);

                        sb.deleteCharAt(i);
                        sb.append(firstChar);
                        if (firstChar != stopChar) {
                            i--;
                        } else {
                            break;
                        }
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[1]);
                    String value = tokens[2];
                    sb.insert(index, value);

                    break;
                case "ChangeAll":
                    String substring = tokens[1];
                    String replacement = tokens[2];
                    //replace, indexOf
                    int indexOfSubstring = sb.indexOf(substring);
                    while(indexOfSubstring != -1) {
                        indexOfSubstring = sb.indexOf(substring);
                        if (indexOfSubstring == -1){
                            break;
                        }
                        sb.replace(indexOfSubstring,
                                indexOfSubstring + substring.length(), replacement);
                    }



                    break;
            }

            line = scanner.nextLine();
        }

        System.out.println("The decrypted message is: " + sb);
    }
}
