package com.campuslab.platform.u202212214.reservations.domain.model.valueobjects;

import com.campuslab.platform.u202212214.shared.domain.exceptions.LocalizedIllegalArgumentException;

import java.util.UUID;

/**
 * @author Oskar Sosa
 */
public record LaboratoryId(UUID value) {

    public LaboratoryId {
        if (value == null) {
            throw new LocalizedIllegalArgumentException(
                    "laboratory.id.required", "Laboratory id is required");
        }
    }
}
