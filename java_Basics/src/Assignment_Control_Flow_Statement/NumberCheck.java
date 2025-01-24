package Assignment_Control_Flow_Statement;
import java.util.*;
public class NumberCheck {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		if(num < 0) {
			System.out.println("Negative");
		}else if(num == 0) {
			System.out.println("Zero");
		}else {
			System.out.println("Positive");
		}
		input.close();
	}

}
