package com.campuslab.platform.u202212214.reservations.domain.repositories;

import com.campuslab.platform.u202212214.reservations.domain.model.aggregates.EquipmentReservation;

/**
 * @author Oskar Sosa
 */
public interface EquipmentReservationRepository {

    EquipmentReservation save(EquipmentReservation reservation);
}
