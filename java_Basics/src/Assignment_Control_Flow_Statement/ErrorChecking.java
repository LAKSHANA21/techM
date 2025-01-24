package Assignment_Control_Flow_Statement;
import java.util.*;
public class ErrorChecking {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int marks = input.nextInt();
		if(marks < 0 || marks > 100) {
			System.out.println("Invalid entry");
		}else {
			System.out.println("Valid entry");
		}
		input.close();
	}

}
