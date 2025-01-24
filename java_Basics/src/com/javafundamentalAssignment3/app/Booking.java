package com.javafundamentalAssignment3.app;

/**
 * Represents a booking for a user.
 */
class Booking {
    private User user;
    private Movie movie;
    private String showTime;
    private Seat seat;

    /**
     * Constructs a new Booking with specified details.
     *
     * @param user     the user who made the booking
     * @param movie    the movie being booked
     * @param showTime the show time of the movie
     * @param seat     the seat being booked
     */
    public Booking(User user, Movie movie, String showTime, Seat seat) {
        this.user = user;
        this.movie = movie;
        this.showTime = showTime;
        this.seat = seat;
    }

    /**
     * Confirms the booking and displays the details.
     */
    public void confirmBooking() {
        System.out.println("\nBooking Confirmed!");
        System.out.println("User: " + user.getUsername());
        System.out.println("Movie: " + movie.getTitle());
        System.out.println("Show Time: " + showTime);
        System.out.println("Seat: " + seat.getSeatId());
    }
}
