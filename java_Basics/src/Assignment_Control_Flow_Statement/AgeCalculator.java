package Assignment_Control_Flow_Statement;
import java.time.*;
import java.util.*;
public class AgeCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int day = input.nextInt();
        int month = input.nextInt();
        int year = input.nextInt();
        LocalDate birthDate = LocalDate.of(year, month, day);
        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(birthDate, currentDate);
        System.out.println("Your age: " 
            + age.getYears() + " years " 
            + age.getMonths() + " months " 
            + age.getDays() + " days");
        input.close();
    }
}

