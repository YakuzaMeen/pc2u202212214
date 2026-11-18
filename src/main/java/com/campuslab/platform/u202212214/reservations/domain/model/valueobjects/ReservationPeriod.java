package com.campuslab.platform.u202212214.reservations.domain.model.valueobjects;

import com.campuslab.platform.u202212214.shared.domain.exceptions.LocalizedIllegalArgumentException;

import java.time.LocalDate;

/**
 * @author Oskar Sosa
 */
public record ReservationPeriod(LocalDate startDate, LocalDate endDate) {

    public ReservationPeriod {
        if (startDate == null || endDate == null) {
            throw new LocalizedIllegalArgumentException(
                    "reservation.period.dates.required", "Start date and end date are required");
        }
        if (!endDate.isAfter(startDate)) {
            throw new LocalizedIllegalArgumentException(
                    "reservation.period.end.after.start", "End date must be after start date");
        }
    }

    public boolean contains(LocalDate checkDate) {
        if (checkDate == null) {
            throw new LocalizedIllegalArgumentException(
                    "reservation.period.check.date.required", "Check date is required");
        }
        return !checkDate.isBefore(startDate) && !checkDate.isAfter(endDate);
    }
}
