package com.campuslab.platform.u202212214.reservations.infrastructure.persistence.jpa.assemblers;

import com.campuslab.platform.u202212214.reservations.domain.model.aggregates.EquipmentReservation;
import com.campuslab.platform.u202212214.reservations.domain.model.valueobjects.EquipmentBatch;
import com.campuslab.platform.u202212214.reservations.domain.model.valueobjects.LaboratoryId;
import com.campuslab.platform.u202212214.reservations.domain.model.valueobjects.ReservationCode;
import com.campuslab.platform.u202212214.reservations.domain.model.valueobjects.ReservationPeriod;
import com.campuslab.platform.u202212214.reservations.infrastructure.persistence.jpa.entities.EquipmentReservationPersistenceEntity;

/**
 * @author Oskar Sosa
 */
public final class EquipmentReservationPersistenceAssembler {

    private EquipmentReservationPersistenceAssembler() {
    }

    public static EquipmentReservationPersistenceEntity toPersistenceFromDomain(EquipmentReservation reservation) {
        var entity = EquipmentReservationPersistenceEntity.builder()
                .reservationCode(reservation.getReservationCode().code())
                .laboratoryId(reservation.getLaboratoryId().value())
                .reservationPeriodStartDate(reservation.getReservationPeriod().startDate())
                .reservationPeriodEndDate(reservation.getReservationPeriod().endDate())
                .equipmentBatchQuantity(reservation.getEquipmentBatch().quantity())
                .equipmentBatchUnit(reservation.getEquipmentBatch().unit())
                .accessLevel(reservation.getAccessLevel())
                .status(reservation.getStatus())
                .reservationNotes(reservation.getReservationNotes())
                .build();
        if (reservation.getId() != null) {
            entity.setId(reservation.getId());
        }
        return entity;
    }

    public static EquipmentReservation toDomainFromPersistence(EquipmentReservationPersistenceEntity entity) {
        return new EquipmentReservation(
                entity.getId(),
                new ReservationCode(entity.getReservationCode()),
                new LaboratoryId(entity.getLaboratoryId()),
                new ReservationPeriod(entity.getReservationPeriodStartDate(), entity.getReservationPeriodEndDate()),
                new EquipmentBatch(entity.getEquipmentBatchQuantity(), entity.getEquipmentBatchUnit()),
                entity.getAccessLevel(),
                entity.getStatus(),
                entity.getReservationNotes(),
                entity.getCreatedAt(),
                entity.getUpdatedAt());
    }
}
