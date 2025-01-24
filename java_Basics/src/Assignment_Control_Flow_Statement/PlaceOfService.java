package Assignment_Control_Flow_Statement;
import java.util.*;
public class PlaceOfService {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int age = input.nextInt();
		char sex = input.next().charAt(0);
		if(sex == 'f' || sex == 'F') {
			System.out.println("Urban Areas");
		}else if(sex == 'M' || sex == 'm' || (age > 20 && age < 40)) {
			System.out.println("Anywhere");
		}else if(sex == 'M' || sex == 'm' || (age > 40 && age < 60)) {
			System.out.println("Urban Areas");
		}else {
			System.out.println("ERROR");
		}
		input.close();
	}

}
