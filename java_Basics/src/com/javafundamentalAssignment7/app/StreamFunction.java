package com.javafundamentalAssignment7.app;
import java.util.*;
import java.util.stream.*;
class Student{
	private String name;
	private int Age;
	private float grade;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public int getAge() {
		return Age;
	}
	
	public void setage(int Age) {
		this.Age=Age;
	}
	
	public float getGrade() {
		return grade;
	}
	
	public void setGrade(float grade) {
		this.grade=grade;
	}
	 
	Student(String name,int Age, float grade){
		this.name=name;
		this.Age=Age;
		this.grade=grade;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}
public class StreamFunction {

	public static void main(String[] args) {
	List<Student> details = new ArrayList<>();
	Scanner input = new Scanner(System.in);
	
	System.out.println("Enter number of students: ");
	int numOfStudents = input.nextInt();
	input.nextLine();
	
	for(int i=0;i<numOfStudents;i++) {
		System.out.printf("Enter the details of Students%d\n",i+1);
		System.out.print("Name: ");
		String name = input.nextLine();
		System.out.print("Age: ");
		int age = input.nextInt();
		System.out.print("Grade: ");
		float grade = input.nextFloat();
		input.nextLine();
		
		details.add(new Student(name, age, grade));
	}
	
	List<String> detail1 = details.stream()
             .filter(age -> age.getAge() >= 18)
             .sorted((a, b) -> Float.compare(b.getGrade(), a.getGrade()))
             .limit(3)
             .map(Student::getName) 
             .collect(Collectors.toList());
	
	System.out.println(detail1);
	input.close();
	}

}
