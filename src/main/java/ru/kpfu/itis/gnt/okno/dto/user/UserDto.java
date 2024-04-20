package ru.kpfu.itis.gnt.okno.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
@Schema(description = "Пользователь.")
public class UserDto {

    @Schema(description = "Идентификатор.")
    public Long id;

    @Schema(description = "Электронная почта.")
    public String email;
}
