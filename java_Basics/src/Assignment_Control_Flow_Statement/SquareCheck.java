package Assignment_Control_Flow_Statement;
import java.util.*;
public class SquareCheck {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the length");
		int length = input.nextInt();
		System.out.println("Enter the breadth");
		int breadth = input.nextInt();
		if(length==breadth) {
			System.out.println("Square");
		}else {
			System.out.println("Not a Square");
		}
		input.close();
	}

}
