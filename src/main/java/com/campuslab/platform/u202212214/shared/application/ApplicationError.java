package com.campuslab.platform.u202212214.shared.application;

/**
 * @author Oskar Sosa
 */
public record ApplicationError(ErrorType type, String messageKey, String defaultMessage, Object... args) {

    public static ApplicationError validation(String messageKey, String defaultMessage, Object... args) {
        return new ApplicationError(ErrorType.VALIDATION, messageKey, defaultMessage, args);
    }

    public static ApplicationError conflict(String messageKey, String defaultMessage, Object... args) {
        return new ApplicationError(ErrorType.CONFLICT, messageKey, defaultMessage, args);
    }

    public static ApplicationError unexpected() {
        return new ApplicationError(ErrorType.UNEXPECTED, "error.unexpected", "An unexpected error occurred");
    }
}
