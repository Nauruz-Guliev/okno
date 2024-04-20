package ru.kpfu.itis.gnt.okno.services.attachment;


import ru.kpfu.itis.gnt.okno.dto.attachment.AttachmentCreateDto;
import ru.kpfu.itis.gnt.okno.dto.attachment.AttachmentDto;
import ru.kpfu.itis.gnt.okno.dto.attachment.AttachmentNonContentDto;
import ru.kpfu.itis.gnt.okno.dto.attachment.AttachmentPage;

public interface AttachmentService {
    AttachmentNonContentDto create(AttachmentCreateDto dto, Long authId);

    AttachmentDto read(Long id, Long authId);

    AttachmentPage listByTask(Long taskId, Integer page, Integer pageSize, Long authId);

    AttachmentNonContentDto delete(Long id, Long authId);
}
