package ru.kpfu.itis.gnt.okno.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO для изменения пользователя.")
public class UserUpdateDto {

    @Schema(description = "Идентификатор.")
    public Long id;

    @Schema(description = "Электронная почта.")
    public String email;

    @Schema(description = "Пароль.")
    public String password;
}
