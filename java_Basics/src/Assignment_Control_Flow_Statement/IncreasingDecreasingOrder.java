package Assignment_Control_Flow_Statement;
import java.util.*;
public class IncreasingDecreasingOrder {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n1 = input.nextInt();
		int n2 = input.nextInt();
		int n3 = input.nextInt();
		if(n3 > n2 && n2 > n1) {
			System.out.println("Increasing");
		}else if(n1 > n2 && n2 > n3) {
			System.out.println("Decreasing");
		}else {
			System.out.println("Neither increasing nor decreasing order");
		}
		input.close();
	}

}
