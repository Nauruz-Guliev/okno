package ru.kpfu.itis.gnt.okno.dto.base;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Ошибка.")
public class ErrorDto {

//    @Schema(description = "Поле.")
//    protected String property;

    @Schema(description = "Сообщение.")
    protected String title;

    @Schema(description = "Подробности сообщения. Для Debug'а.")
    protected String details;

//    public ErrorDto(String property, String title, String details) {
//        this.property = property;
//        this.title = title;
//        this.details = details;
//    }

    public ErrorDto(String title, String details) {
        this.title = title;
        this.details = details;
    }
}
