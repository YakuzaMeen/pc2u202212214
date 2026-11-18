package com.campuslab.platform.u202212214.reservations.infrastructure.persistence.jpa.entities;

import com.campuslab.platform.u202212214.reservations.domain.model.valueobjects.ReservationStatus;
import com.campuslab.platform.u202212214.shared.infrastructure.persistence.jpa.entities.AuditableAbstractPersistenceEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.UUID;

/**
 * @author Oskar Sosa
 */
@Entity
@Table(name = "equipment_reservations",
        uniqueConstraints = @UniqueConstraint(
                name = "uk_equipment_reservations_reservation_code", columnNames = "reservation_code"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EquipmentReservationPersistenceEntity extends AuditableAbstractPersistenceEntity {

    @Column(name = "reservation_code", nullable = false)
    private String reservationCode;

    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "laboratory_id", nullable = false, length = 36)
    private UUID laboratoryId;

    @Column(name = "reservation_period_start_date", nullable = false)
    private LocalDate reservationPeriodStartDate;

    @Column(name = "reservation_period_end_date", nullable = false)
    private LocalDate reservationPeriodEndDate;

    @Column(name = "equipment_batch_quantity", nullable = false)
    private Integer equipmentBatchQuantity;

    @Column(name = "equipment_batch_unit", nullable = false)
    private String equipmentBatchUnit;

    @Column(name = "access_level", nullable = false)
    private Integer accessLevel;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ReservationStatus status;

    @Column(name = "reservation_notes", length = 500)
    private String reservationNotes;
}
