package Assignment_Control_Flow_Statement;
import java.util.Scanner;

public class ExamEligibility {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int totalClasses = input.nextInt();
        int attendedClasses = input.nextInt();
        double attendancePercentage = ((double) attendedClasses / totalClasses) * 100;
        if (attendancePercentage < 75) {
            char medicalCause = input.next().charAt(0);
            if (medicalCause == 'Y' || medicalCause == 'y') {
                System.out.println((int) attendancePercentage + "% Allowed");
            } else {
                System.out.println((int) attendancePercentage + "% Not allowed");
            }
        } else {
            System.out.println((int) attendancePercentage + "% Allowed");
        }
        input.close();
    }
}
