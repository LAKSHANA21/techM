package Assignment_Control_Flow_Statement;
import java.util.Scanner;
public class StoreBillingSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String customerName = input.nextLine();
        int numberOfItems = input.nextInt();
        int costPerItem;
        if (numberOfItems < 10) {
            costPerItem = 12;
        } else if (numberOfItems >= 10 && numberOfItems <= 99) {
            costPerItem = 10;
        } else {
            costPerItem = 7;
        }
        int totalCost = numberOfItems * costPerItem;
        System.out.println(customerName + " " + totalCost);
        input.close();
    }
}

