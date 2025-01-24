package Assignment_Control_Flow_Statement;
import java.util.Scanner;
public class PowerOf{

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		double result = Math.pow(n,m);
		System.out.println((int)result);
		input.close();
	}

}
