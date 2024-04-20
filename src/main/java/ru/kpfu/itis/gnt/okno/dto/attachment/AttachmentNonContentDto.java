package ru.kpfu.itis.gnt.okno.dto.attachment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Schema(description = "Вложение.")
public class AttachmentNonContentDto {

    @Schema(description = "Идентификатор.")
    public long id;

    @Schema(description = "Название.")
    public String name;

    @Schema(description = "Задача.")
    public Long taskId;

    @Schema(description = "Тип содержимого.")
    public String contentType;
}
