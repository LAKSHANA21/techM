package Assignment_Control_Flow_Statement;
import java.util.*;
public class ATMLockdownPolicy {
    public static void main(String[] args) {
        int balance = 10000;
        Scanner input = new Scanner(System.in);
        int amount = input.nextInt();
        if (amount % 500 != 0) {
            System.out.println("Please enter amount multiple of 500.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance in ATM.");
        } else {
            System.out.println("Valid amount, transaction in process.");
            balance -= amount;
        }
        input.close();
    }
}

