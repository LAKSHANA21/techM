package com.javafundamentalAssignment2.app;

import java.util.Scanner;

public class MovieGenere {
    public static void main(String[] args) {
        String[] movieNames = {
            "The Matrix", "Inception", "Avengers: Endgame", "The Dark Knight",
            "Titanic", "The Lion King", "Home Alone", "The Pursuit of Happyness",
            "Tenali Raman", "Moana2"
        };

        String[] movieGenres = {
            "SCI-FI", "SCI-FI", "ACTION", "ACTION", "ROMANCE", "ANIMATION",
            "COMEDY", "DRAMA", "COMEDY", "COMEDY"
        };

        System.out.println("Available Genres: ");
        for (int i = 0; i < movieGenres.length; i++) {
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (movieGenres[i].equalsIgnoreCase(movieGenres[j])) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                System.out.println("- " + movieGenres[i]);
            }
        }

        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter a genre to search for movies: ");
        String inputGenre = input.nextLine().trim();

        boolean found = false;
        System.out.println("\nMovies in the genre '" + inputGenre + "':");
        for (int i = 0; i < movieGenres.length; i++) {
            if (movieGenres[i].equalsIgnoreCase(inputGenre)) {
                System.out.println("- " + movieNames[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No movies found for the selected genre.");
        }
        input.close();
    }
}


