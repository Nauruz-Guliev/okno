package ru.kpfu.itis.gnt.okno.services.task;

import org.springframework.stereotype.Component;
import ru.kpfu.itis.gnt.okno.dal.models.Task;
import ru.kpfu.itis.gnt.okno.dal.models.User;
import ru.kpfu.itis.gnt.okno.dto.task.TaskCreateDto;
import ru.kpfu.itis.gnt.okno.dto.task.TaskDto;
import ru.kpfu.itis.gnt.okno.dto.task.TaskUpdateDto;


@Component
public class TaskMapperImpl implements TaskMapper {
    @Override
    public TaskDto map(Task dal) {
        return TaskDto.builder()
                .id(dal.getId())
                .name(dal.getName())
                .description((dal.getDescription()))
                .userId(dal.getUser().getId())
                .isCompleted(dal.getIsCompleted())
                .lastModifiedTime(dal.getLastModifiedTime())
                .deadlineTime(dal.getDeadlineTime())
                .completedTime(dal.getCompletedTime())
                .build();
    }

    @Override
    public Task map(TaskCreateDto dto) {
        return Task.builder()
                .name(dto.name)
                .description(dto.description)
                .user(new User(dto.userId))
                .deadlineTime(dto.deadlineTime)
                .isCompleted(false)
                .build();
    }

    @Override
    public Task map(Task dal, TaskUpdateDto dto) {
        dal.setName(dto.name);
        dal.setDescription(dto.description);
        dal.setUser(new User(dto.userId));
        dal.setDeadlineTime(dto.deadlineTime);
        return dal;
    }
}
