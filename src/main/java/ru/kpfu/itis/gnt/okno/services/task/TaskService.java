package ru.kpfu.itis.gnt.okno.services.task;


import ru.kpfu.itis.gnt.okno.dto.task.TaskCreateDto;
import ru.kpfu.itis.gnt.okno.dto.task.TaskDto;
import ru.kpfu.itis.gnt.okno.dto.task.TaskPage;
import ru.kpfu.itis.gnt.okno.dto.task.TaskUpdateDto;

public interface TaskService {

    TaskDto create(TaskCreateDto dto, Long authId);

    TaskDto read(Long id, Long authId);

    TaskDto update(TaskUpdateDto dto, Long authId);

    TaskDto delete(Long id, Long authId);

    TaskDto markAsCompleted(Long id, Long authId);

    TaskDto markAsUncompleted(Long id, Long authId);

    TaskPage uncompletedListOrderByDeadline(Long userId, Integer page, Integer pageSize, Long authId);

    TaskPage completedListOrderByCompletedDesc(Long userId, Integer page, Integer pageSize, Long authId);
}
