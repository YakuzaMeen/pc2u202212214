package com.campuslab.platform.u202212214.reservations.interfaces.rest.resources;

import com.campuslab.platform.u202212214.reservations.domain.model.valueobjects.ReservationStatus;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

/**
 * @author Oskar Sosa
 */
@Getter
@Setter
public class CreateEquipmentReservationResource {

    @NotBlank(message = "{reservation.code.required}")
    private String reservationCode;

    @NotNull(message = "{laboratory.id.required}")
    private UUID laboratoryId;

    @NotNull(message = "{reservation.period.dates.required}")
    private LocalDate reservationPeriodStartDate;

    @NotNull(message = "{reservation.period.dates.required}")
    private LocalDate reservationPeriodEndDate;

    @NotNull(message = "{equipment.batch.quantity.invalid}")
    @Positive(message = "{equipment.batch.quantity.invalid}")
    private Integer equipmentBatchQuantity;

    @NotBlank(message = "{equipment.batch.unit.required}")
    private String equipmentBatchUnit;

    @NotNull(message = "{access.level.range}")
    @Min(value = 1, message = "{access.level.range}")
    @Max(value = 5, message = "{access.level.range}")
    private Integer accessLevel;

    @NotNull(message = "{reservation.status.required}")
    private ReservationStatus status = ReservationStatus.PENDING;

    private String reservationNotes;
}
