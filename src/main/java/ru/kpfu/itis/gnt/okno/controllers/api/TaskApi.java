package ru.kpfu.itis.gnt.okno.controllers.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.gnt.okno.dto.base.Response;
import ru.kpfu.itis.gnt.okno.dto.task.TaskCreateDto;
import ru.kpfu.itis.gnt.okno.dto.task.TaskDto;
import ru.kpfu.itis.gnt.okno.dto.task.TaskPage;
import ru.kpfu.itis.gnt.okno.dto.task.TaskUpdateDto;


@Tags(value = {
        @Tag(name = "Task. Задача.")
})
@RequestMapping("/task")
public interface TaskApi {

    @Operation(summary = "Добавить.")
    @PostMapping
    Response<TaskDto> create(@RequestBody TaskCreateDto dto,
                             @Parameter(description = "Идентификатор для авторизации.")
                             @RequestHeader(name = "Auth") Long authId);

    @Operation(summary = "Получить.")
    @GetMapping("/{task-id}")
    Response<TaskDto> read(@Parameter(description = "Идентификатор.")
                           @PathVariable("task-id") Long id,
                           @Parameter(description = "Идентификатор для авторизации.")
                           @RequestHeader(name = "Auth") Long authId);

    @Operation(summary = "Изменить.")
    @PutMapping
    Response<TaskDto> update(@RequestBody TaskUpdateDto dto,
                             @Parameter(description = "Идентификатор для авторизации.")
                             @RequestHeader(name = "Auth") Long authId);

    @Operation(summary = "Удалить.")
    @DeleteMapping("/{task-id}")
    Response<TaskDto> delete(@Parameter(description = "Идентификатор.")
                             @PathVariable("task-id") Long id,
                             @Parameter(description = "Идентификатор для авторизации.")
                             @RequestHeader(name = "Auth") Long authId);


    @Operation(summary = "Пометить выполненным.")
    @PutMapping("mark_as_completed/{task-id}")
    Response<TaskDto> markAsCompleted(@Parameter(description = "Идентификатор.")
                                     @PathVariable("task-id") Long id,
                                     @Parameter(description = "Идентификатор для авторизации.")
                                     @RequestHeader(name = "Auth") Long authId);

    @Operation(summary = "Пометить невыполненным.")
    @PutMapping("mark_as_uncompleted/{task-id}")
    Response<TaskDto> markAsUncompleted(@Parameter(description = "Идентификатор.")
                                       @PathVariable("task-id") Long id,
                                       @Parameter(description = "Идентификатор для авторизации.")
                                       @RequestHeader(name = "Auth") Long authId);

    @Operation(summary = "Получить активные задачи.")
    @GetMapping("uncompleted_list/order_by_deadline/{user-id}")
    Response<TaskPage> uncompletedListOrderByDeadline(@Parameter(description = "Идентификатор пользователя.")
                                                      @PathVariable("user-id") Long userId,
                                                      @Parameter(description = "Номер страницы.")
                                                      @RequestParam("page") Integer page,
                                                      @Parameter(description = "Размер страницы.")
                                                      @RequestParam("pageSize") Integer pageSize,
                                                      @Parameter(description = "Идентификатор для авторизации.")
                                                      @RequestHeader(name = "Auth") Long authId);

    @Operation(summary = "Получить архив.")
    @GetMapping("completed_list/order_by_completed_desc/{user-id}")
    Response<TaskPage> completedListOrderByCompletedDesc(@Parameter(description = "Идентификатор пользователя.")
                                                         @PathVariable("user-id") Long userId,
                                                         @Parameter(description = "Номер страницы.")
                                                         @RequestParam("page") Integer page,
                                                         @Parameter(description = "Размер страницы.")
                                                         @RequestParam("pageSize") Integer pageSize,
                                                         @Parameter(description = "Идентификатор для авторизации.")
                                                         @RequestHeader(name = "Auth") Long authId);

}
