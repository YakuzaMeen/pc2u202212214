package com.campuslab.platform.u202212214.reservations.domain.model.valueobjects;

import com.campuslab.platform.u202212214.shared.domain.exceptions.LocalizedIllegalArgumentException;

/**
 * @author Oskar Sosa
 */
public record EquipmentBatch(Integer quantity, String unit) {

    public EquipmentBatch {
        if (quantity == null || quantity <= 0) {
            throw new LocalizedIllegalArgumentException(
                    "equipment.batch.quantity.invalid", "Quantity must be greater than 0");
        }
        if (unit == null || unit.isBlank()) {
            throw new LocalizedIllegalArgumentException(
                    "equipment.batch.unit.required", "Unit is required and cannot be blank");
        }
    }

    public EquipmentBatch addUnits(Integer additionalQuantity) {
        if (additionalQuantity == null || additionalQuantity <= 0) {
            throw new LocalizedIllegalArgumentException(
                    "equipment.batch.increment.invalid", "Additional quantity must be greater than 0");
        }
        if (additionalQuantity > Integer.MAX_VALUE - quantity) {
            throw new LocalizedIllegalArgumentException(
                    "equipment.batch.overflow", "Resulting quantity exceeds the maximum allowed value");
        }
        return new EquipmentBatch(quantity + additionalQuantity, unit);
    }
}
