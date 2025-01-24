package com.javafundamentalAssignment3.app;

import java.util.Scanner;

/**
 * Main class for the Movie Ticket Booking System.
 */
public class MovieTicketBookingSystem {
    private static User[] users = {
        new User("Lakshu", "Lakshu123", "How many days in a week?", "7"),
        new User("Jaswin", "Jaswin123", "How many weeks in a year?", "52"),
        new User("Amirtha", "Amritha123", "How many hours in a day?", "24"),
        new User("Deepak", "Deepak123", "What is the capital city of TamilNadu", "Chennai"),
        new User("Nikitha", "Nikitha123", "How many wheels does the car have?", "4"),
        new User("Deva", "Deva123", "What is your childhood nickname?", "Dev")
    };

    private static Movie[] movies = {
        new Movie("AMARAN", new String[]{"10:00 AM", "1:00 PM"}, 5, 5),
        new Movie("LUCKY BASKAR", new String[]{"11:00 AM", "2:00 PM"}, 5, 5)
    };

    /**
     * Main method to start the system.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        User loggedInUser = null;

        while (loggedInUser == null) {
            try {
                System.out.println("1. Login\n2. Forgot Password\n3. New User Registration");
                System.out.print("Enter your choice: ");
                int choice = input.nextInt();
                input.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        loggedInUser = login(input);
                        break;
                    case 2:
                        forgotPassword(input);
                        break;
                    case 3:
                        registerNewUser(input);
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage() + " Please try again.");
                input.nextLine(); // Clear invalid input
            }
        }

        try {
            System.out.println("\nAvailable Movies:");
            for (int i = 0; i < movies.length; i++) {
                System.out.println((i + 1) + ". " + movies[i].getTitle());
            }

            System.out.print("Select a movie 1 or 2: ");
            int movieIndex = input.nextInt() - 1;

            if (movieIndex < 0 || movieIndex >= movies.length) {
                throw new IllegalArgumentException("Invalid movie selection.");
            }

            movies[movieIndex].displayShows();
            System.out.print("Select a show 1 or 2: ");
            int showIndex = input.nextInt() - 1;

            if (showIndex < 0 || showIndex >= movies[movieIndex].getShowTimes().length) {
                throw new IllegalArgumentException("Invalid show selection.");
            }

            movies[movieIndex].displaySeats(showIndex);
            System.out.print("Select a seat e.g: A1: ");

            String seatId = input.next();
            Seat selectedSeat = movies[movieIndex].getSeat(showIndex, seatId);

            while (selectedSeat == null || !selectedSeat.isAvailable()) {
                System.out.println("Invalid or unavailable seat. Please select another.");
                seatId = input.next();
                selectedSeat = movies[movieIndex].getSeat(showIndex, seatId);
            }

            selectedSeat.reserve();

            Booking booking = new Booking(loggedInUser, movies[movieIndex], movies[movieIndex].getShowTimes()[showIndex], selectedSeat);
            booking.confirmBooking();

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        } finally {
            input.close();
        }
    }

    /**
     * Handles user login.
     *
     * @param input the Scanner object for user input
     * @return the logged-in User object if successful, null otherwise
     */
    private static User login(Scanner input) {
        System.out.print("Enter username: ");
        String username = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        for (User user : users) {
            if (user.validate(username, password)) {
                return user;
            }
        }

        System.out.println("Invalid credentials. Please try again.");
        return null;
    }

    /**
     * Handles password recovery for a user.
     *
     * @param scanner the Scanner object for user input
     */
    private static void forgotPassword(Scanner scanner) {
        try {
            System.out.print("Enter your username: ");
            String username = scanner.nextLine();

            for (User user : users) {
                if (user.getUsername().equals(username)) {
                    System.out.println("Hint Question: " + user.getQuestion());
                    System.out.print("Answer: ");
                    String answer = scanner.nextLine();

                    if (user.validateAnswer(answer)) {
                        System.out.print("Enter new password: ");
                        String newPassword = scanner.nextLine();
                        user.setPassword(newPassword);
                        System.out.println("Password updated successfully.");
                    } else {
                        System.out.println("Incorrect answer. Unable to reset password.");
                    }
                    return;
                }
            }

            System.out.println("Username not found.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Registers a new user.
     *
     * @param scanner the Scanner object for user input
     */
    private static void registerNewUser(Scanner scanner) {
        try {
            System.out.print("Enter a new username: ");
            String newUsername = scanner.nextLine();

            for (User user : users) {
                if (user.getUsername().equals(newUsername)) {
                    System.out.println("Username already exists. Please try a different one.");
                    return;
                }
            }

            System.out.print("Enter a new password: ");
            String newPassword = scanner.nextLine();

            System.out.print("Set a hint question: ");
            String hintQuestion = scanner.nextLine();

            System.out.print("Set the answer to the hint question: ");
            String hintAnswer = scanner.nextLine();

            User newUser = new User(newUsername, newPassword, hintQuestion, hintAnswer);

            User[] updatedUsers = new User[users.length + 1];
            System.arraycopy(users, 0, updatedUsers, 0, users.length);
            updatedUsers[users.length] = newUser;
            users = updatedUsers;

            System.out.println("Registration successful. You can now log in.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
