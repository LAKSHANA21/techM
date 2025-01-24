package Assignment_Control_Flow_Statement;
import java.util.*;
public class MovieClub {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int age = input.nextInt();
		if(age > 0) {
			if(age <= 10) {
				System.out.println("Cartoon Club");
			}else if(age > 10 && age <= 15) {
				System.out.println("Teens Club");
			}else {
				System.out.println("Not Allowed");
			}
		}else {
			System.out.println("Invalid Age");
		}
		input.close();
	}

}
