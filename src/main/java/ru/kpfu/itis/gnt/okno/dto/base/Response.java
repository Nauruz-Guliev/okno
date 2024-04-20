package ru.kpfu.itis.gnt.okno.dto.base;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.kpfu.itis.gnt.okno.exceptions.ApplicationException;

@Data
@Schema(description = "Ответ.")
public class Response<T> {

    @Schema(description = "Данные.")
    public T data;

    public Boolean isSuccess;

    public ErrorDto error;

    public Response(T data) {
        this.data = data;
        this.isSuccess = true;
    }

    public Response(ErrorDto error) {
        this.error = error;
        this.isSuccess = false;
    }

    public static <T> Response<T> of(T data) {
        return new Response<>(data);
    }

    public static <T> Response<T> of(ApplicationException ex) {
        return new Response<>(new ErrorDto(ex.getMessage(), ex.getDetails()));
    }

    public static <T> Response<T> of(Throwable ex) {
        return new Response<>(new ErrorDto("Something went wrong with server, try again.", ex.getMessage()));
    }

}
