package com.campuslab.platform.u202212214.reservations.domain.model.valueobjects;

import com.campuslab.platform.u202212214.shared.domain.exceptions.LocalizedIllegalArgumentException;

/**
 * @author Oskar Sosa
 */
public record ReservationCode(String code) {

    public ReservationCode {
        if (code == null || code.isBlank()) {
            throw new LocalizedIllegalArgumentException(
                    "reservation.code.required", "Reservation code is required and cannot be blank");
        }
    }
}
