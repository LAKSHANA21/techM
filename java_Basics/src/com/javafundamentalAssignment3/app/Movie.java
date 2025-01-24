package com.javafundamentalAssignment3.app;

/**
 * Represents a movie with its title, show times, and seats.
 */
class Movie {
    private String title;
    private String[] showTimes;
    private Seat[][] seats;

    /**
     * Constructs a new Movie with specified details.
     *
     * @param title     the title of the movie
     * @param showTimes the available show times
     * @param rows      the number of seat rows per show time
     * @param cols      the number of seat columns per show time
     */
    public Movie(String title, String[] showTimes, int rows, int cols) {
        this.title = title;
        this.showTimes = showTimes;
        int k = 1;
        seats = new Seat[showTimes.length][rows * cols];

        for (int i = 0; i < showTimes.length; i++) {
            for (int j = 0; j < rows * cols; j++) {
                seats[i][j] = new Seat("A" + k);
                k++;
            }
        }
    }

    /**
     * Displays available show times.
     */
    public void displayShows() {
        System.out.println("Available Show Timings:");
        for (int i = 0; i < showTimes.length; i++) {
            System.out.println((i + 1) + ". " + showTimes[i]);
        }
    }

    /**
     * Displays available seats for a given show time.
     *
     * @param showIndex the index of the show time
     */
    public void displaySeats(int showIndex) {
        System.out.println("Available Seats for " + showTimes[showIndex] + ":");
        for (Seat seat : seats[showIndex]) {
            if (seat.isAvailable()) {
                System.out.print(seat.getSeatId() + " ");
            }
        }
        System.out.println();
    }

    /**
     * Gets a seat by its ID for a specific show time.
     *
     * @param showIndex the index of the show time
     * @param seatId    the ID of the seat
     * @return the Seat object if found, null otherwise
     */
    public Seat getSeat(int showIndex, String seatId) {
        for (Seat seat : seats[showIndex]) {
            if (seat.getSeatId().equalsIgnoreCase(seatId)) {
                return seat;
            }
        }
        return null;
    }

    /**
     * Gets the title of the movie.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the show times of the movie.
     *
     * @return an array of show times
     */
    public String[] getShowTimes() {
        return showTimes;
    }
}