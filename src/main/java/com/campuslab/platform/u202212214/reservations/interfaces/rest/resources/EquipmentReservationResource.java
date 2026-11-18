package com.campuslab.platform.u202212214.reservations.interfaces.rest.resources;

/**
 * @author Oskar Sosa
 */
public record EquipmentReservationResource(
        Long id,
        String reservationCode,
        String laboratoryId,
        String reservationPeriodStartDate,
        String reservationPeriodEndDate,
        Integer equipmentBatchQuantity,
        String equipmentBatchUnit,
        Integer accessLevel,
        String status,
        String reservationNotes
) {
}
