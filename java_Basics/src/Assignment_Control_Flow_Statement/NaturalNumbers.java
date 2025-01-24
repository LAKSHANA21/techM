package Assignment_Control_Flow_Statement;
import java.util.*;
public class NaturalNumbers {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		for(int i=1;i<=n;i++) {
			System.out.print(i+"s");
		}
		input.close();
	}

}
