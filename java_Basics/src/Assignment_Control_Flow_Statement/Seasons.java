package Assignment_Control_Flow_Statement;
import java.util.*;
public class Seasons {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int month = input.nextInt();
		switch(month) {
		case 12,1,2:
			System.out.println("Winter");
		    break;
		    
		case 3,4,5:
			System.out.println("Spring");
		    break;
		    
		case 6,7,8:
			System.out.println("Summer");
		    break;
		   
		case 9,10,11:
			System.out.println("Autumn");
		    break;
		    
		default:
			System.out.println("Invalid month");
			break;
		}
		input.close();
	}

}
