package com.javafundamentalAssignment7.app;
import java.util.*;
import java.util.stream.*;

class Course{
	private String title;
	private String instructor;
	private int duration;
	private double rating;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title=title;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor=instructor;
	}
	
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration=duration;
	}
	
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating=rating;
	}
	
	Course(String title, String instructor, int duration, double rating){
		this.title=title;
		this.instructor=instructor;
		this.duration=duration;
		this.rating=rating;
	}
	
	public String toString() {
		return title + "(" +duration+"hours)";
	}
}
public class OnlineCoursePlatform {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		List<Course> ocp = new ArrayList<>();
		
		System.out.println("Enter number of courses");
		int noOfCourses = input.nextInt();
		input.nextLine();
		
		for(int i=0;i<noOfCourses;i++) {
			System.out.println("Enter the details of the courses");
			System.out.print("Title:");
			String title = input.nextLine();
			System.out.print("Instructor: ");
			String instructor=input.nextLine();
			System.out.print("Duration: ");
			int duration=input.nextInt();
			System.out.print("Ratings: ");
			double rating=input.nextDouble();
			input.nextLine();
			
			ocp.add(new Course(title,instructor,duration,rating));
		}
		
		List<Course> ocp1 = ocp.stream()
				.filter(d->d.getDuration()>10)
				.collect(Collectors.toList());
		
		List<String> ocp2 = ocp.stream()
				.map(course->course.toString())
				.collect(Collectors.toList());
		System.out.println("Course titles and duration"+ocp2);
		
		Course longestCourse = ocp.stream().max(Comparator.comparingInt(Course::getDuration))
                .orElse(null);
		System.out.println("Longest Course: "+longestCourse);

		int totalDuration = ocp.stream().mapToInt(Course::getDuration).sum();
        double averageRating = ocp.stream()
                .mapToDouble(Course::getRating)
                .average()
                .orElse(0.0);
        System.out.println("Total duration: " + totalDuration + " hours");
        System.out.printf("Average rating: %.1f\n", averageRating);
        
        boolean allHighRated = ocp.stream()
                .allMatch(course -> course.getRating() >= 4.0);
        System.out.println("All courses have a rating of 4.0 or higher: " + allHighRated);

        input.close();
	}

}
