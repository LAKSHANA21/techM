package Assignment_Control_Flow_Statement;
import java.util.*;
public class CodeProcessor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); 
        int code = input.nextInt();    
        switch (code) {
            case 1: 
                double num1 = input.nextDouble();
                double num2 = input.nextDouble();
                System.out.println(num1 + num2);
                break;

            case 2:
                int num3 = input.nextInt();
                int num4 = input.nextInt();
                System.out.println(num3 * num4);
                break;

            case 3: 
                String str1 = input.next();
                String str2 = input.next();
                System.out.println(str1 + str2);
                break;

            default: 
                System.out.println("Invalid Code");
                break;
        }
        input.close();
    }
}

