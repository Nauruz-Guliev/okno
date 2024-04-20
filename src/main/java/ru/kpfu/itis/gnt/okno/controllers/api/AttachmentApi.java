package ru.kpfu.itis.gnt.okno.controllers.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.gnt.okno.dto.attachment.AttachmentCreateDto;
import ru.kpfu.itis.gnt.okno.dto.attachment.AttachmentDto;
import ru.kpfu.itis.gnt.okno.dto.attachment.AttachmentNonContentDto;
import ru.kpfu.itis.gnt.okno.dto.attachment.AttachmentPage;
import ru.kpfu.itis.gnt.okno.dto.base.Response;

@Tags(value = {
        @Tag(name = "Attachment. Вложение.")
})
@RequestMapping("/attachment")
public interface AttachmentApi {

    @Operation(summary = "Добавить.")
    @PostMapping()
    Response<AttachmentNonContentDto> create(@RequestBody AttachmentCreateDto dto,
                                             @Parameter(description = "Идентификатор для авторизации.")
                                             @RequestHeader(name = "Auth") Long authId);

    @Operation(summary = "Получить.")
    @GetMapping(value = "/{attachment-id}")
    Response<AttachmentDto> read(@Parameter(description = "Идентификатор.")
                                 @PathVariable("attachment-id") Long id,
                                 @Parameter(description = "Идентификатор для авторизации.")
                                 @RequestHeader(name = "Auth") Long authId);

    @Operation(summary = "Список вложений по задаче.")
    @GetMapping("/list_by_task/{task-id}")
    Response<AttachmentPage> listByTask(@Parameter(description = "Идентификатор задачи.")
                                        @PathVariable("task-id") Long taskId,
                                        @Parameter(description = "Номер страницы.")
                                        @RequestParam("page") Integer page,
                                        @Parameter(description = "Размер страницы.")
                                        @RequestParam("pageSize") Integer pageSize,
                                        @Parameter(description = "Идентификатор для авторизации.")
                                        @RequestHeader(name = "Auth") Long authId);

    @Operation(summary = "Удалить.")
    @DeleteMapping("/{attachment-id}")
    Response<AttachmentNonContentDto> delete(@Parameter(description = "Идентификатор.")
                                             @PathVariable("attachment-id") Long id,
                                             @Parameter(description = "Идентификатор для авторизации.")
                                             @RequestHeader(name = "Auth") Long authId);
}
