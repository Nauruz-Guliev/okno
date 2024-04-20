package ru.kpfu.itis.gnt.okno.services.task;


import ru.kpfu.itis.gnt.okno.dal.models.Task;
import ru.kpfu.itis.gnt.okno.dto.task.TaskCreateDto;
import ru.kpfu.itis.gnt.okno.dto.task.TaskDto;
import ru.kpfu.itis.gnt.okno.dto.task.TaskUpdateDto;

import java.util.List;

public interface TaskMapper {
    TaskDto map(Task dal);

    default List<TaskDto> map(List<Task> dalList) {
        return dalList.stream().map(this::map).toList();
    }

    Task map(TaskCreateDto dto);

    Task map(Task dal, TaskUpdateDto dto);
}
