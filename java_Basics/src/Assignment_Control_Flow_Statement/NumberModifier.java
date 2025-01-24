package Assignment_Control_Flow_Statement;
import java.util.*;
public class NumberModifier {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int currentNumber = input.nextInt();
		if(currentNumber%2!=0) {
			int oddRes = (currentNumber*3)+1;
			System.out.println(oddRes);
		}else {
			int evenRes = currentNumber/2;
			System.out.println(evenRes);
		}
		input.close();
	}

}
