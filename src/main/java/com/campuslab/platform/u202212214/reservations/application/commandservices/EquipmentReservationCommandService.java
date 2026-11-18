package com.campuslab.platform.u202212214.reservations.application.commandservices;

import com.campuslab.platform.u202212214.reservations.domain.model.aggregates.EquipmentReservation;
import com.campuslab.platform.u202212214.reservations.domain.model.commands.CreateEquipmentReservationCommand;
import com.campuslab.platform.u202212214.shared.application.Result;

/**
 * @author Oskar Sosa
 */
public interface EquipmentReservationCommandService {

    Result<EquipmentReservation> handle(CreateEquipmentReservationCommand command);
}
