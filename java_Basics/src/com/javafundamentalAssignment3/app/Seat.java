package com.javafundamentalAssignment3.app;


/**
 * Represents a seat in a theater.
 */
class Seat {
    private String seatId;
    private boolean isReserved;

    /**
     * Constructs a new Seat with the specified ID.
     *
     * @param seatId the ID of the seat
     */
    public Seat(String seatId) {
        this.seatId = seatId;
        this.isReserved = false;
    }

    /**
     * Checks if the seat is available.
     *
     * @return true if the seat is not reserved, false otherwise
     */
    public boolean isAvailable() {
        return !isReserved;
    }

    /**
     * Reserves the seat.
     */
    public void reserve() {
        isReserved = true;
    }

    /**
     * Gets the seat ID.
     *
     * @return the seat ID
     */
    public String getSeatId() {
        return seatId;
    }
}

