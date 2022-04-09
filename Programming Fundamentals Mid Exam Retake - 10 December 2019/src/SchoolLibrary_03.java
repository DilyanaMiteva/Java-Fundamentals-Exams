import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SchoolLibrary_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = Arrays.stream(scanner.nextLine().split("&"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Done")) {
            String[] booksAndCommand = input.split(" \\| ");
            String command = booksAndCommand[0];
            String book = booksAndCommand[1];
            switch (command) {
                case "Add Book":
                    if (!list.contains(book)) {
                        list.add(0, book);
                    }
                    break;
                case "Take Book":
                    if (!list.contains(book)) {
                        break;
                    } else {
                        list.remove(book);
                    }

                    break;
                case "Swap Books":
                    String book2 = booksAndCommand[2];
                    if (list.contains(book) && list.contains(book2)) {
                        String temp = book;
                        book = book2;
                        book2 = temp;

                        int indexBook = list.indexOf(book);
                        int indexBook2 = list.indexOf(book2);
                        Collections.swap(list, indexBook, indexBook2);
                        break;


                    }

                    break;
                case "Insert Book":
                    list.add(book);
                    break;
                case "Check Book":
                    for (int i = 0; i < list.size(); i++) {
                        int index = Integer.parseInt(book);
                        if (index > 0 && index < list.size()) {
                            System.out.println(list.get(index));
                            break;
                        }
                    }
                    break;
            }


            input = scanner.nextLine();
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) {
                System.out.print(", ");
            }
        }


    }
}
