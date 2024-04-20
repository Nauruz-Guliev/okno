package ru.kpfu.itis.gnt.okno.aspects;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.kpfu.itis.gnt.okno.dto.base.Response;
import ru.kpfu.itis.gnt.okno.exceptions.ApplicationException;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public Response<Object> handleApplicationException(ApplicationException ex) {
        return Response.of(ex);
    }

    @ExceptionHandler(Throwable.class)
    public Response<Object> handleThrowable(Throwable ex) {
        return Response.of(ex);
    }
}
