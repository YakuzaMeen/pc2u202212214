package com.campuslab.platform.u202212214.reservations.domain.model.aggregates;

import com.campuslab.platform.u202212214.reservations.domain.model.commands.CreateEquipmentReservationCommand;
import com.campuslab.platform.u202212214.reservations.domain.model.valueobjects.EquipmentBatch;
import com.campuslab.platform.u202212214.reservations.domain.model.valueobjects.LaboratoryId;
import com.campuslab.platform.u202212214.reservations.domain.model.valueobjects.ReservationCode;
import com.campuslab.platform.u202212214.reservations.domain.model.valueobjects.ReservationPeriod;
import com.campuslab.platform.u202212214.reservations.domain.model.valueobjects.ReservationStatus;
import com.campuslab.platform.u202212214.shared.domain.exceptions.LocalizedIllegalArgumentException;
import com.campuslab.platform.u202212214.shared.domain.model.aggregates.AbstractDomainAggregateRoot;

import java.time.Instant;

/**
 * @author Oskar Sosa
 */
public class EquipmentReservation extends AbstractDomainAggregateRoot {

    private static final int MIN_ACCESS_LEVEL = 1;
    private static final int MAX_ACCESS_LEVEL = 5;

    private final ReservationCode reservationCode;
    private final LaboratoryId laboratoryId;
    private final ReservationPeriod reservationPeriod;
    private final EquipmentBatch equipmentBatch;
    private final Integer accessLevel;
    private final ReservationStatus status;
    private final String reservationNotes;

    public EquipmentReservation(CreateEquipmentReservationCommand command) {
        this(null,
                new ReservationCode(command.reservationCode()),
                new LaboratoryId(command.laboratoryId()),
                new ReservationPeriod(command.reservationPeriodStartDate(), command.reservationPeriodEndDate()),
                new EquipmentBatch(command.equipmentBatchQuantity(), command.equipmentBatchUnit()),
                command.accessLevel(),
                command.status(),
                command.reservationNotes(),
                null,
                null);
    }

    public EquipmentReservation(Long id, ReservationCode reservationCode, LaboratoryId laboratoryId,
                                ReservationPeriod reservationPeriod, EquipmentBatch equipmentBatch,
                                Integer accessLevel, ReservationStatus status, String reservationNotes,
                                Instant createdAt, Instant updatedAt) {
        super(id, createdAt, updatedAt);
        if (accessLevel == null || accessLevel < MIN_ACCESS_LEVEL || accessLevel > MAX_ACCESS_LEVEL) {
            throw new LocalizedIllegalArgumentException(
                    "access.level.range", "Access level must be between 1 and 5");
        }
        this.reservationCode = reservationCode;
        this.laboratoryId = laboratoryId;
        this.reservationPeriod = reservationPeriod;
        this.equipmentBatch = equipmentBatch;
        this.accessLevel = accessLevel;
        this.status = status == null ? ReservationStatus.PENDING : status;
        this.reservationNotes = reservationNotes;
    }

    public ReservationCode getReservationCode() {
        return reservationCode;
    }

    public LaboratoryId getLaboratoryId() {
        return laboratoryId;
    }

    public ReservationPeriod getReservationPeriod() {
        return reservationPeriod;
    }

    public EquipmentBatch getEquipmentBatch() {
        return equipmentBatch;
    }

    public Integer getAccessLevel() {
        return accessLevel;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public String getReservationNotes() {
        return reservationNotes;
    }
}
