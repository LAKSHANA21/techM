package Assignment_Control_Flow_Statement;
import java.util.*;
public class SumOfNumbers {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int a[]= new int[n];
		for(int i=0;i<n;i++) {
			a[i]=input.nextInt();
		}
		int sum=0;
		for(int i=0;i<n;i++) {
			sum+=a[i];
		}
		System.out.println(sum);
		input.close();

	}

}
