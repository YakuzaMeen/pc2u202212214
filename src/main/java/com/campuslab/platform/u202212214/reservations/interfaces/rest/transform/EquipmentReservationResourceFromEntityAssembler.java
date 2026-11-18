package com.campuslab.platform.u202212214.reservations.interfaces.rest.transform;

import com.campuslab.platform.u202212214.reservations.domain.model.aggregates.EquipmentReservation;
import com.campuslab.platform.u202212214.reservations.interfaces.rest.resources.EquipmentReservationResource;

/**
 * @author Oskar Sosa
 */
public final class EquipmentReservationResourceFromEntityAssembler {

    private EquipmentReservationResourceFromEntityAssembler() {
    }

    public static EquipmentReservationResource toResourceFromEntity(EquipmentReservation reservation) {
        return new EquipmentReservationResource(
                reservation.getId(),
                reservation.getReservationCode().code(),
                reservation.getLaboratoryId().value().toString(),
                reservation.getReservationPeriod().startDate().toString(),
                reservation.getReservationPeriod().endDate().toString(),
                reservation.getEquipmentBatch().quantity(),
                reservation.getEquipmentBatch().unit(),
                reservation.getAccessLevel(),
                reservation.getStatus().name(),
                reservation.getReservationNotes());
    }
}
