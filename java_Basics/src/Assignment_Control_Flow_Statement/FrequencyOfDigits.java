package Assignment_Control_Flow_Statement;
import java.util.Scanner;
public class FrequencyOfDigits {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String number = input.nextLine();
        int[] arr = new int[10];
        for (char digit : number.toCharArray()) {
            arr[digit - '0']++;
        }
        for (int i = 0; i < 10; i++) {
            if (arr[i] > 0) {
                System.out.println(i + " occurs " + arr[i] + " times");
            }
        }
        input.close();
    }
}
