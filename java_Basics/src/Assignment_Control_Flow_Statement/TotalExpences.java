package Assignment_Control_Flow_Statement;
import java.util.*;
public class TotalExpences {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int quantity = input.nextInt();
		float amount = input.nextFloat();
		float totalAmount = quantity*amount;
		float result;
		if(quantity > 1000) {
			float discountAmount = (10f/100)*totalAmount;
			result = totalAmount-discountAmount;
			System.out.println(result);
		}else {
			System.out.println(totalAmount);
		}
		input.close();
	}

}
