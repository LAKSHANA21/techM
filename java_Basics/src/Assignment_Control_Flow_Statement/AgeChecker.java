package Assignment_Control_Flow_Statement;
import java.util.*;
public class AgeChecker {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int age = input.nextInt();
		if(age >= 4) {
			System.out.println("Eligible");
		}else {
			System.out.println("Not Eligible");
		}
		input.close();
	}

}
