package com.campuslab.platform.u202212214.shared.domain.exceptions;

/**
 * @author Oskar Sosa
 */
public class LocalizedIllegalArgumentException extends IllegalArgumentException {

    private final String messageKey;
    private final transient Object[] args;

    public LocalizedIllegalArgumentException(String messageKey, String defaultMessage, Object... args) {
        super(defaultMessage);
        this.messageKey = messageKey;
        this.args = args;
    }

    public String getMessageKey() {
        return messageKey;
    }

    public Object[] getArgs() {
        return args;
    }
}
