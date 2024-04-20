package ru.kpfu.itis.gnt.okno.controllers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.itis.gnt.okno.controllers.api.AttachmentApi;
import ru.kpfu.itis.gnt.okno.dto.attachment.AttachmentCreateDto;
import ru.kpfu.itis.gnt.okno.dto.attachment.AttachmentDto;
import ru.kpfu.itis.gnt.okno.dto.attachment.AttachmentNonContentDto;
import ru.kpfu.itis.gnt.okno.dto.attachment.AttachmentPage;
import ru.kpfu.itis.gnt.okno.dto.base.Response;
import ru.kpfu.itis.gnt.okno.services.attachment.AttachmentService;

@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AttachmentController implements AttachmentApi {

    AttachmentService service;

    public Response<AttachmentNonContentDto> create(AttachmentCreateDto dto, Long authId) {
        return Response.of(
                service.create(dto, authId));
    }
    public Response<AttachmentDto> read(Long id, Long authId) {
        return Response.of(
                service.read(id, authId));
    }

    public Response<AttachmentPage> listByTask(Long taskId, Integer page, Integer pageSize, Long authId) {
        return Response.of(
                service.listByTask(taskId, page, pageSize, authId));
    }

    public Response<AttachmentNonContentDto> delete(Long id, Long authId) {
        return Response.of(
                service.delete(id, authId));
    }
}
