package Assignment_Control_Flow_Statement;
import java.util.*;
public class BudgetDisplay {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		float cost = input.nextFloat();
		if(cost <= 15000) {
			System.out.println("Mobile chosen is within the budget");			
		}else {
			System.out.println("Mobile chosen is beyond the budget");
		}
		input.close();
	}

}
