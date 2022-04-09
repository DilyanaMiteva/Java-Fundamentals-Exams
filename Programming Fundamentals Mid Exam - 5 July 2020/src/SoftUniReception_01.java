import java.util.Scanner;

public class SoftUniReception_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());
        int third = Integer.parseInt(scanner.nextLine());
        int allStudents = Integer.parseInt(scanner.nextLine());
        int hours = 0;

        int servedStudentsPerHour = first + second + third;
        while (allStudents > 0) {
            hours++;
            if (hours % 4 != 0) {
                allStudents -= servedStudentsPerHour;

            }
        }
        System.out.printf("Time needed: %dh.",hours);
    }
}
