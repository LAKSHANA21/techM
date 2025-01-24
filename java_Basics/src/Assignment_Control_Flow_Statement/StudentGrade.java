package Assignment_Control_Flow_Statement;
import java.util.Scanner;
public class StudentGrade {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the marks: ");
        int marks = input.nextInt();
        String grade;
        if (marks > 90) {
            grade = "O";
        } else if (marks >= 81 && marks <= 90) {
            grade = "A";
        } else if (marks >= 71 && marks <= 80) {
            grade = "B";
        } else if (marks >= 61 && marks <= 70) {
            grade = "C";
        } else if (marks >= 50 && marks <= 60) {
            grade = "D";
        } else {
            grade = "F";
        }
        System.out.println("Grade: " + grade);
        input.close();
    }
}

