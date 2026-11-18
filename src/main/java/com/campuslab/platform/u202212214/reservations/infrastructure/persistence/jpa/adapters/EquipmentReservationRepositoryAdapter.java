package com.campuslab.platform.u202212214.reservations.infrastructure.persistence.jpa.adapters;

import com.campuslab.platform.u202212214.reservations.domain.exceptions.ReservationCodeAlreadyExistsException;
import com.campuslab.platform.u202212214.reservations.domain.model.aggregates.EquipmentReservation;
import com.campuslab.platform.u202212214.reservations.domain.repositories.EquipmentReservationRepository;
import com.campuslab.platform.u202212214.reservations.infrastructure.persistence.jpa.assemblers.EquipmentReservationPersistenceAssembler;
import com.campuslab.platform.u202212214.reservations.infrastructure.persistence.jpa.repositories.EquipmentReservationJpaRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

/**
 * @author Oskar Sosa
 */
@Component
public class EquipmentReservationRepositoryAdapter implements EquipmentReservationRepository {

    private final EquipmentReservationJpaRepository jpaRepository;

    public EquipmentReservationRepositoryAdapter(EquipmentReservationJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public EquipmentReservation save(EquipmentReservation reservation) {
        try {
            var saved = jpaRepository.saveAndFlush(
                    EquipmentReservationPersistenceAssembler.toPersistenceFromDomain(reservation));
            return EquipmentReservationPersistenceAssembler.toDomainFromPersistence(saved);
        } catch (DataIntegrityViolationException exception) {
            throw new ReservationCodeAlreadyExistsException(reservation.getReservationCode().code());
        }
    }
}
