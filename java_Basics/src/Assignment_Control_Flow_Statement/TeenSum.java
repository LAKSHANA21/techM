package Assignment_Control_Flow_Statement;
import java.util.*;
public class TeenSum {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int b = input.nextInt();
		int c = a+b;
		if(a <= 12 && b <= 12) {
			System.out.println(c);
		}else {
			System.out.println("19");
		}
		input.close();
	}
}