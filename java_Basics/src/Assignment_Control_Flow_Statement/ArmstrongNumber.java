package Assignment_Control_Flow_Statement;
import java.util.*;
public class ArmstrongNumber {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int temp=n;
		int sum =0;
		int digit=String.valueOf(n).length();
		
		while(n!=0) {
			int rem = n%10;
			sum+=Math.pow(rem,digit);
			n/=10;
		}
		if(sum==temp) {
			System.out.println("True");
		}else {
			System.out.println("Flase");
		}
		input.close();
	}

}
