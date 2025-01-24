package com.javafundamentalAssignment7.app;
import java.util.*;
import java.util.stream.*;

class Movie{
	private String title;
	private String genre;
	private double rating;
	private int releaseYear;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title=title;
	}
	
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre=genre;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating=rating;
	}
	
	public int getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(int releaseYear) {
		this.releaseYear=releaseYear;
	}
	
	Movie(String title, String genre, double rating, int releaseYear){
		this.title=title;
		this.genre=genre;
		this.rating=rating;
		this.releaseYear=releaseYear;
	}
}
public class MovieRecomendationSystem {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		List<Movie> mrs = new ArrayList<>();
		
		System.out.println("Enter the number of movies");
		int noOfMovies=input.nextInt();
		input.nextLine();
		
		for(int i=0;i<noOfMovies;i++) {
			System.out.printf("Enter the details of the Movie %d\n",i+1);
			System.out.print("Title:");
			String title = input.nextLine();
			System.out.print("Genre:");
			String genre = input.nextLine();
			System.out.print("Rating:");
			double rating = input.nextDouble();
			System.out.print("ReleasesYear:");
			int releaseYear=input.nextInt();
			input.nextLine();
			
			mrs.add(new Movie(title,genre,rating,releaseYear));
		}
		
		List<Movie> movie=mrs.stream()
				.filter(m->m.getReleaseYear()>=2000)
				.collect(Collectors.toList());
		
		Map<String, List<Movie>> movie1=movie.stream()
				.collect(Collectors.groupingBy(Movie::getGenre));
		
		Map<String, Double> averageRating = movie1.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .mapToDouble(Movie::getRating)
                                .average()
                                .orElse(0.0)
                ));

        Optional<Map.Entry<String, Double>> highestRatedGenre = averageRating.entrySet().stream()
                .max(Map.Entry.comparingByValue());

        if (highestRatedGenre.isPresent()) {
            System.out.println("Genre with the highest average rating: " + highestRatedGenre.get().getKey() + ", Average Rating: " + highestRatedGenre.get().getValue());
        } else {
            System.out.println("Genre with the highest average rating: No genres found, Average Rating: 0");
        }
	
	}

}
