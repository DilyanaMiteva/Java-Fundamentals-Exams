import java.util.Scanner;

public class Problem_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();
        String line = scanner.nextLine();

        String newString = "";

        StringBuilder sb = new StringBuilder();

        while (!line.equals("Done")) {
            String[] tokens = line.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Change":
                    String charInInput = tokens[1];
                    String replacement = tokens[2];
                    newString = string.replace(charInInput, replacement);
                    string = newString;
                    System.out.println(string);

                    break;
                case "Includes":
                    String includesString = tokens[1];
                    if (string.contains(includesString)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "End":
                    String endString = tokens[1];
                    /*int lengthInEndString = endString.length();
                   *//* for (int i = string.length() - 1 - lengthInEndString - 1; i < string.length() - 1; i++) {
                        newString += string.charAt(i);
                    }
                    if (newString.equals(endString)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }*/

                    String lastWord = string.substring(string.lastIndexOf(" ") + 1, string.length() - 3);

                    if (endString.equals(lastWord)){
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }

                    break;
                case "Uppercase":
                    newString = string.toUpperCase();
                    string = newString;
                    System.out.println(string);
                    break;
                case "FindIndex":
                    String charInput = tokens[1];
                    int indexOfString = string.indexOf(charInput);
                    System.out.println(indexOfString);
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);
                    newString = string.substring(startIndex, startIndex + length);
                    string = newString;



                    System.out.println(string);
                    break;
            }


            line = scanner.nextLine();
        }
    }
}
