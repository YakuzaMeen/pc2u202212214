package com.campuslab.platform.u202212214.reservations.interfaces.rest.transform;

import com.campuslab.platform.u202212214.reservations.domain.model.commands.CreateEquipmentReservationCommand;
import com.campuslab.platform.u202212214.reservations.interfaces.rest.resources.CreateEquipmentReservationResource;

/**
 * @author Oskar Sosa
 */
public final class CreateEquipmentReservationCommandFromResourceAssembler {

    private CreateEquipmentReservationCommandFromResourceAssembler() {
    }

    public static CreateEquipmentReservationCommand toCommandFromResource(
            CreateEquipmentReservationResource resource) {
        return new CreateEquipmentReservationCommand(
                resource.getReservationCode(),
                resource.getLaboratoryId(),
                resource.getReservationPeriodStartDate(),
                resource.getReservationPeriodEndDate(),
                resource.getEquipmentBatchQuantity(),
                resource.getEquipmentBatchUnit(),
                resource.getAccessLevel(),
                resource.getStatus(),
                resource.getReservationNotes());
    }
}
