package Assignment_Control_Flow_Statement;
import java.util.Scanner;
public class BabyLionBehaviour {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int totalAnimals = input.nextInt();
        int rabbits = input.nextInt();
        int deer = input.nextInt();
        int birds = input.nextInt();
        int squirrels = input.nextInt();

        int totalCount = rabbits + deer + birds + squirrels;

        if (totalCount == totalAnimals - 1) {
            System.out.println("Baby lion is well behaved");
        } else if (totalCount < totalAnimals - 1) {
            System.out.println("Baby lion is mischievous");
        } else {
            System.out.println("Counted wrongly");
        }
        input.close();
    }
}
