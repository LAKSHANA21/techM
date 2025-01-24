package Assignment_Control_Flow_Statement;
import java.util.*;

public class ShoppingDiscount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double shoppingAmount = input.nextDouble();
        double discountPercentage;
        
        if (shoppingAmount >= 5000) {
            discountPercentage = 25;
        } else if (shoppingAmount >= 1000) {
            discountPercentage = 10;
        } else {
            discountPercentage = 5;
        }
        
        double discountAmount = (discountPercentage / 100) * shoppingAmount;
        double finalAmount = shoppingAmount - discountAmount;
        
        System.out.println("Shopping Amount: " + shoppingAmount);
        System.out.println("Discount Percentage: " + discountPercentage + "%");
        System.out.println("Discount Amount: " + discountAmount);
        System.out.println("Final Amount to be Paid: " + finalAmount);
        input.close();
    }
}

