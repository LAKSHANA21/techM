package Assignment_Control_Flow_Statement;
import java.util.Scanner;
public class TaxDetection {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int income = input.nextInt();
        int taxFreeLimit = 250000;
        if (income <= taxFreeLimit) {
            System.out.println("You are exempted from tax");
        } else {
            float taxableIncome = income - taxFreeLimit;
            float tax = (10f / 100) * taxableIncome;
            System.out.println("Tax amount is " + tax);
        }
        input.close();
    }
}
