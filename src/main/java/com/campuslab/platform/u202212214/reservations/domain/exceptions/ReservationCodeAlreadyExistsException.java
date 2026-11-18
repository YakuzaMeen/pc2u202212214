package com.campuslab.platform.u202212214.reservations.domain.exceptions;

/**
 * @author Oskar Sosa
 */
public class ReservationCodeAlreadyExistsException extends RuntimeException {

    private final String reservationCode;

    public ReservationCodeAlreadyExistsException(String reservationCode) {
        super("Reservation code already exists: " + reservationCode);
        this.reservationCode = reservationCode;
    }

    public String getReservationCode() {
        return reservationCode;
    }
}
