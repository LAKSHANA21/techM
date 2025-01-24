package Assignment_Control_Flow_Statement;
import java.util.*;
public class OddOrEven {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the Number");
		int num = input.nextInt();
		if(num%2==0) {
			System.out.println("Even");
		}else {
			System.out.println("Odd");
		}
		input.close();
	}

}
