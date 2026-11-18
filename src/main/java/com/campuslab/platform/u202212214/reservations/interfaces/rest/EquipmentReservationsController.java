package com.campuslab.platform.u202212214.reservations.interfaces.rest;

import com.campuslab.platform.u202212214.reservations.application.commandservices.EquipmentReservationCommandService;
import com.campuslab.platform.u202212214.reservations.domain.model.aggregates.EquipmentReservation;
import com.campuslab.platform.u202212214.reservations.interfaces.rest.resources.CreateEquipmentReservationResource;
import com.campuslab.platform.u202212214.reservations.interfaces.rest.resources.EquipmentReservationResource;
import com.campuslab.platform.u202212214.reservations.interfaces.rest.transform.CreateEquipmentReservationCommandFromResourceAssembler;
import com.campuslab.platform.u202212214.reservations.interfaces.rest.transform.EquipmentReservationResourceFromEntityAssembler;
import com.campuslab.platform.u202212214.shared.application.Result;
import com.campuslab.platform.u202212214.shared.interfaces.rest.transform.ApplicationErrorResponseAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Oskar Sosa
 */
@RestController
@RequestMapping(value = "/api/v1/equipment-reservations", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Equipment Reservations", description = "Equipment reservation endpoints")
public class EquipmentReservationsController {

    private final EquipmentReservationCommandService commandService;
    private final ApplicationErrorResponseAssembler errorAssembler;

    public EquipmentReservationsController(EquipmentReservationCommandService commandService,
                                           ApplicationErrorResponseAssembler errorAssembler) {
        this.commandService = commandService;
        this.errorAssembler = errorAssembler;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create an equipment reservation",
            description = "Registers a new equipment reservation for a laboratory")
    public ResponseEntity<?> createEquipmentReservation(
            @Valid @RequestBody CreateEquipmentReservationResource resource) {
        var command = CreateEquipmentReservationCommandFromResourceAssembler.toCommandFromResource(resource);
        Result<EquipmentReservation> result = commandService.handle(command);
        return switch (result) {
            case Result.Success<EquipmentReservation> success -> ResponseEntity.status(HttpStatus.CREATED)
                    .body(EquipmentReservationResourceFromEntityAssembler.toResourceFromEntity(success.value()));
            case Result.Failure<EquipmentReservation> failure -> errorAssembler.toResponseEntity(failure.error());
        };
    }
}
