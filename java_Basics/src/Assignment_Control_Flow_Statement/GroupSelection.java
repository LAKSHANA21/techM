package Assignment_Control_Flow_Statement;
import java.util.*;
public class GroupSelection {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int ticketNumber = input.nextInt();
		if(ticketNumber%10 == 0) {
			System.out.println("Group Leader");
		}else {
			System.out.println("Group Member");
		}
		input.close();
	}

}
