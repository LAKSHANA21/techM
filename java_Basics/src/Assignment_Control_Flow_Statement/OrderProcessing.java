package Assignment_Control_Flow_Statement;
import java.util.*;
public class OrderProcessing {
    public static void main(String[] args) {
        final int initialStock = 100;
        int stock = initialStock;
        Scanner input = new Scanner(System.in);
        int orderQuantity = input.nextInt();
        int currentStock = input.nextInt();
        char creditStatus = input.next().charAt(0);

        if (creditStatus == 'Y') {
            if (orderQuantity <= currentStock) {
                System.out.println(orderQuantity + " supplied");
            } else {
                System.out.println(orderQuantity + " supplied. Out of stock. Balance will be refunded.");
            }
        } else {
            System.out.println("Cannot supply. Intimation sent.");
        }

        input.close();
    }
}
