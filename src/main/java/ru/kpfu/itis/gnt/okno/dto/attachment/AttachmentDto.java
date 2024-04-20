package ru.kpfu.itis.gnt.okno.dto.attachment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Schema(description = "Вложение.")
public class AttachmentDto extends AttachmentNonContentDto {

    @Schema(description = "Контент.")
    public byte[] content;

}
