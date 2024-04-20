package ru.kpfu.itis.gnt.okno.dto.task;

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
@Schema(description = "Страница с задачами и общее количество страниц.")
public class TaskPage {

    @Schema(description = "Список задач.")
    private List<TaskDto> taskList;

    @Schema(description = "Общее количество страниц.")
    private Integer totalPagesCount;
}
