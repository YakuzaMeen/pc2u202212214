package com.campuslab.platform.u202212214.shared.application;

/**
 * @author Oskar Sosa
 */
public sealed interface Result<T> permits Result.Success, Result.Failure {

    record Success<T>(T value) implements Result<T> {
    }

    record Failure<T>(ApplicationError error) implements Result<T> {
    }

    static <T> Result<T> success(T value) {
        return new Success<>(value);
    }

    static <T> Result<T> failure(ApplicationError error) {
        return new Failure<>(error);
    }
}
