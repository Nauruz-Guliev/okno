package ru.kpfu.itis.gnt.okno.dto.attachment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Страница с вложениями и общее количество страниц.")
public class AttachmentPage {

    @Schema(description = "Список вложений.")
    private List<AttachmentNonContentDto> attachmentList;

    @Schema(description = "Общее количество страниц.")
    private Integer totalPagesCount;
}
