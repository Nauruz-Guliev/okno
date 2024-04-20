package ru.kpfu.itis.gnt.okno.controllers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.itis.gnt.okno.controllers.api.TaskApi;
import ru.kpfu.itis.gnt.okno.dto.base.Response;
import ru.kpfu.itis.gnt.okno.dto.task.TaskCreateDto;
import ru.kpfu.itis.gnt.okno.dto.task.TaskDto;
import ru.kpfu.itis.gnt.okno.dto.task.TaskPage;
import ru.kpfu.itis.gnt.okno.dto.task.TaskUpdateDto;
import ru.kpfu.itis.gnt.okno.services.task.TaskService;


@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TaskController implements TaskApi {

    TaskService service;

    public Response<TaskDto> create(TaskCreateDto dto, Long authId) {
        return Response.of(
                service.create(dto, authId));
    }

    public Response<TaskDto> read(Long id, Long authId) {
        return Response.of(
                service.read(id, authId));
    }

    public Response<TaskDto> update(TaskUpdateDto dto, Long authId) {
        return Response.of(
                service.update(dto, authId));
    }

    public Response<TaskDto> delete(Long id, Long authId) {
        return Response.of(
                service.delete(id, authId));
    }

    public Response<TaskDto> markAsCompleted(Long id, Long authId) {
        return Response.of(
                service.markAsCompleted(id, authId));
    }

    public Response<TaskDto> markAsUncompleted(Long id, Long authId) {
        return Response.of(
                service.markAsUncompleted(id, authId));
    }

    public Response<TaskPage> uncompletedListOrderByDeadline(Long userId, Integer page, Integer pageSize, Long authId) {
        return Response.of(
                service.uncompletedListOrderByDeadline(userId, page, pageSize, authId));
    }

    public Response<TaskPage> completedListOrderByCompletedDesc(Long userId, Integer page, Integer pageSize, Long authId) {
        return Response.of(
                service.completedListOrderByCompletedDesc(userId, page, pageSize, authId));
    }

}
