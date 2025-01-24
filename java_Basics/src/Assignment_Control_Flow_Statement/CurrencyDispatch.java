package Assignment_Control_Flow_Statement;
import java.util.*;
public class CurrencyDispatch {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int amount = input.nextInt();
		if(amount%500==0) {
			int notes = amount/100;
			System.out.println("Please dispatch "+notes+" notes of 100");
		}else {
			System.out.println("please enter the amount multiple of 500");
		}
		input.close();
	}

}
