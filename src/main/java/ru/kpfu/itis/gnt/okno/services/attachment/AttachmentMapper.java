package ru.kpfu.itis.gnt.okno.services.attachment;

import ru.kpfu.itis.gnt.okno.dal.models.Attachment;
import ru.kpfu.itis.gnt.okno.dto.attachment.AttachmentCreateDto;
import ru.kpfu.itis.gnt.okno.dto.attachment.AttachmentDto;
import ru.kpfu.itis.gnt.okno.dto.attachment.AttachmentNonContentDto;

import java.util.List;

public interface AttachmentMapper {

    AttachmentDto map(Attachment dal);

    AttachmentNonContentDto mapNonContent(Attachment dal);
    default List<AttachmentNonContentDto> mapNonContent(List<Attachment> dalList) {
        return dalList.stream().map(this::mapNonContent).toList();
    }

    Attachment map(AttachmentCreateDto dto);

}
