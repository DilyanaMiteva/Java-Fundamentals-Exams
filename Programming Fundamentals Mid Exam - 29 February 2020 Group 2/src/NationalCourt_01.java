import java.util.Scanner;

public class NationalCourt_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());
        int third = Integer.parseInt(scanner.nextLine());
        int possibleQuestionsPerHour = first + second + third;
        int questions = Integer.parseInt(scanner.nextLine());
        int hour = 0;

        while (questions > 0){
            hour++;
            if (hour % 4 != 0){
                questions -= possibleQuestionsPerHour;
            }
        }
        System.out.printf("Time needed: %dh.", hour);
    }
}
