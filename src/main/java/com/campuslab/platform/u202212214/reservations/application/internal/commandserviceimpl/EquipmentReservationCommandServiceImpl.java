package com.campuslab.platform.u202212214.reservations.application.internal.commandserviceimpl;

import com.campuslab.platform.u202212214.reservations.application.commandservices.EquipmentReservationCommandService;
import com.campuslab.platform.u202212214.reservations.domain.exceptions.ReservationCodeAlreadyExistsException;
import com.campuslab.platform.u202212214.reservations.domain.model.aggregates.EquipmentReservation;
import com.campuslab.platform.u202212214.reservations.domain.model.commands.CreateEquipmentReservationCommand;
import com.campuslab.platform.u202212214.reservations.domain.repositories.EquipmentReservationRepository;
import com.campuslab.platform.u202212214.shared.application.ApplicationError;
import com.campuslab.platform.u202212214.shared.application.Result;
import com.campuslab.platform.u202212214.shared.domain.exceptions.LocalizedIllegalArgumentException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Oskar Sosa
 */
@Slf4j
@Service
public class EquipmentReservationCommandServiceImpl implements EquipmentReservationCommandService {

    private final EquipmentReservationRepository repository;

    public EquipmentReservationCommandServiceImpl(EquipmentReservationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Result<EquipmentReservation> handle(CreateEquipmentReservationCommand command) {
        try {
            var reservation = new EquipmentReservation(command);
            return Result.success(repository.save(reservation));
        } catch (ReservationCodeAlreadyExistsException exception) {
            return Result.failure(ApplicationError.conflict(
                    "reservation.code.duplicated", exception.getMessage(), exception.getReservationCode()));
        } catch (LocalizedIllegalArgumentException exception) {
            return Result.failure(ApplicationError.validation(
                    exception.getMessageKey(), exception.getMessage(), exception.getArgs()));
        } catch (IllegalArgumentException exception) {
            return Result.failure(ApplicationError.validation("error.request.invalid", exception.getMessage()));
        } catch (RuntimeException exception) {
            log.error("Unexpected error while creating equipment reservation", exception);
            return Result.failure(ApplicationError.unexpected());
        }
    }
}
