package ru.kpfu.itis.gnt.okno.exceptions;

import lombok.Getter;
/**
 * Exception, отлавливаемый RestExceptionHandler. Рекомендуется использовать его.
 */
@Getter
public class ApplicationException extends RuntimeException {

    protected final String details;

    public ApplicationException(String message, String... details) {
        super(message);
        this.details = String.join(";", details);
    }
}
