package ru.kpfu.itis.gnt.okno.dto.attachment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
@Schema(description = "DTO для создания вложения.")
public class AttachmentCreateDto {

    @Schema(description = "Название.")
    public String name;

    @Schema(description = "Тип содержимого.")
    public String contentType;

    @Schema(description = "Задача.")
    public Long taskId;

    @Schema(description = "Содержимое.")
    public byte[] content;
}
