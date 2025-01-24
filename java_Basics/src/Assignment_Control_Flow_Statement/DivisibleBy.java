package Assignment_Control_Flow_Statement;
import java.util.*;
public class DivisibleBy {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int a[] = new int[n];
		for(int i=0;i<n;i++) {
			if(a[i]%3==0 || a[i]%5==0) {
				a[i]=input.nextInt();
				System.out.println(a[i]);
			}
		}
		input.close();
	}

}
