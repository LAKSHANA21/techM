package Assignment_Control_Flow_Statement;
import java.util.*;
public class EmployeeBonus {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		float salary = input.nextFloat();
		int yearOfService = input.nextInt();
		float result;
		if(yearOfService > 5) {
			result=(5f/100)*salary;
			System.out.println(result);
		}else {
			System.out.println("0");
		}
		input.close();
	}

}
