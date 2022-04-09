import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String regex = "@#+[A-Z][A-Za-z0-9}]{4,}[A-Z]@#+";
        Pattern pattern = Pattern.compile(regex);

        String productGroup = "";

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String digitsRegex = "\\d";
                Pattern digitsPattern = Pattern.compile(digitsRegex);
                matcher = digitsPattern.matcher(input);

                while (matcher.find()) {
                    productGroup += matcher.group();
                }
                if (productGroup.equals("")) {
                    productGroup = "00";
                }

                System.out.println("Product group: " + productGroup);
                productGroup = "";

            } else {
                System.out.println("Invalid barcode");
            }

        }

    }
}
