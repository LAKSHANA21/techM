package Assignment_Control_Flow_Statement;
import java.util.*;
public class BirthRigth {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int age1 = input.nextInt();
		int age2 = input.nextInt();
		int age3 = input.nextInt();
		if(age1 > age2 && age1 > age3) {
			System.out.println("Choi Sung");
		}else if(age2 > age1 && age2 > age3) {
			System.out.println("Moui Sung");
		}else {
			System.out.println("Bhoi Sung");
		}
		input.close();
	}

}
