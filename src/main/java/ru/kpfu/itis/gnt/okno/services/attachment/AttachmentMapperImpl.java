package ru.kpfu.itis.gnt.okno.services.attachment;

import org.springframework.stereotype.Component;
import ru.kpfu.itis.gnt.okno.dal.models.Attachment;
import ru.kpfu.itis.gnt.okno.dal.models.Task;
import ru.kpfu.itis.gnt.okno.dto.attachment.AttachmentCreateDto;
import ru.kpfu.itis.gnt.okno.dto.attachment.AttachmentDto;
import ru.kpfu.itis.gnt.okno.dto.attachment.AttachmentNonContentDto;


@Component
public class AttachmentMapperImpl implements AttachmentMapper {

    public AttachmentDto map(Attachment dal) {
        return AttachmentDto.builder()
                .id(dal.getId())
                .name(dal.getName())
                .taskId(dal.getTask().getId())
                .contentType(dal.getContentType())
                .content(dal.getContent())
                .build();
    }

    public AttachmentNonContentDto mapNonContent(Attachment dal) {
        return AttachmentNonContentDto.builder()
                .id(dal.getId())
                .name(dal.getName())
                .taskId(dal.getTask().getId())
                .contentType(dal.getContentType())
                .build();
    }

    public Attachment map(AttachmentCreateDto dto) {
        return Attachment.builder()
                .name(dto.name)
                .contentType(dto.contentType)
                .task(new Task(dto.taskId))
                .content(dto.content)
                .build();
    }
}
