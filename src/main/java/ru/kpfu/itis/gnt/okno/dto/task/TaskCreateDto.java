package ru.kpfu.itis.gnt.okno.dto.task;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "DTO для создания задачи.")
public class TaskCreateDto {

    @Schema(description = "Название.")
    public String name;

    @Schema(description = "Описание.")
    public String description;

    @Schema(description = "Пользователь.")
    public long userId;

    @Schema(description = "Дата дедлайна.")
    public LocalDateTime deadlineTime;

}
