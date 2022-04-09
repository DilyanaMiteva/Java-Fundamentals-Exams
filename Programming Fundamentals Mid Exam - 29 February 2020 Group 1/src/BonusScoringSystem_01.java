import java.util.Scanner;

public class BonusScoringSystem_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOfStudents = Integer.parseInt(scanner.nextLine());
        int countOfLectures = Integer.parseInt(scanner.nextLine());
        int initialBonus = Integer.parseInt(scanner.nextLine());

        double maxBonus = 0;
        int maxAttendance = 0;

        for (int i = 0; i < countOfStudents; i++) {
            int attendancesOfEachStudent = Integer.parseInt(scanner.nextLine());

            double totalBonus = (1.0 * attendancesOfEachStudent / countOfLectures) * (5 + initialBonus);

            if (totalBonus > maxBonus){
                maxBonus = totalBonus;
            }

            if (attendancesOfEachStudent > maxAttendance){
                maxAttendance = attendancesOfEachStudent;
            }
        }
        System.out.printf("Max Bonus: %.0f.%n", Math.ceil(maxBonus));
        System.out.printf("The student has attended %d lectures.", maxAttendance);

    }
}
