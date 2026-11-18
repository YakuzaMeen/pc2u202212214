package com.campuslab.platform.u202212214.shared.interfaces.rest.transform;

import com.campuslab.platform.u202212214.shared.application.ApplicationError;
import com.campuslab.platform.u202212214.shared.interfaces.rest.resources.MessageResource;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * @author Oskar Sosa
 */
@Component
public class ApplicationErrorResponseAssembler {

    private final MessageSource messageSource;

    public ApplicationErrorResponseAssembler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public ResponseEntity<MessageResource> toResponseEntity(ApplicationError error) {
        var message = messageSource.getMessage(
                error.messageKey(), error.args(), error.defaultMessage(), LocaleContextHolder.getLocale());
        var status = switch (error.type()) {
            case VALIDATION -> HttpStatus.BAD_REQUEST;
            case CONFLICT -> HttpStatus.CONFLICT;
            case UNEXPECTED -> HttpStatus.INTERNAL_SERVER_ERROR;
        };
        return ResponseEntity.status(status).body(new MessageResource(message));
    }
}
