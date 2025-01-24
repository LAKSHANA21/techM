package Assignment_Control_Flow_Statement;
import java.util.*;
public class GradeEvaluator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int value = input.nextInt();
        if (value == 9 || value == 10) {
            System.out.println("Excellent");
        } else if (value == 7 || value == 8) {
            System.out.println("Notable");
        } else if (value == 6) {
            System.out.println("Good");
        } else if (value == 5) {
            System.out.println("Approved");
        } else if (value >= 0 && value <= 4) {
            System.out.println("Fail");
        } else {
            System.out.println("Invalid");
        }
        input.close();
    }
}

