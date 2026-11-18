package com.campuslab.platform.u202212214.reservations.infrastructure.persistence.jpa.repositories;

import com.campuslab.platform.u202212214.reservations.infrastructure.persistence.jpa.entities.EquipmentReservationPersistenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Oskar Sosa
 */
public interface EquipmentReservationJpaRepository extends JpaRepository<EquipmentReservationPersistenceEntity, Long> {
}
