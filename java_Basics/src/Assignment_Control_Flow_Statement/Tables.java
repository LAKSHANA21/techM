package Assignment_Control_Flow_Statement;
import java.util.*;
public class Tables {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		for(int i=1;i<=10;i++) {
			System.out.print(n*i+" ");
		}
		input.close();
	}

}
