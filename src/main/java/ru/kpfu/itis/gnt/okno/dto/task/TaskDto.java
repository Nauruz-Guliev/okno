package ru.kpfu.itis.gnt.okno.dto.task;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
@Schema(description = "Задача.")
public class TaskDto {

    @Schema(description = "Идентификатор.")
    public long id;

    @Schema(description = "Название.")
    public String name;

    @Schema(description = "Описание.")
    public String description;

    @Schema(description = "Пользователь.")
    public long userId;

    @Schema(description = "Сделана ли задача.")
    public Boolean isCompleted;

    @Schema(description = "Дата последнего изменения.")
    public LocalDateTime lastModifiedTime;

    @Schema(description = "Дата дедлайна.")
    public LocalDateTime deadlineTime;

    @Schema(description = "Дата выполнения.")
    public LocalDateTime completedTime;

}
