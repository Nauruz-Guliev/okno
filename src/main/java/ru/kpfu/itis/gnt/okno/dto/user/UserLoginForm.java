package ru.kpfu.itis.gnt.okno.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO для аутентификации.")
public class UserLoginForm {

    @Schema(description = "Логин.")
    public String login;

    @Schema(description = "Пароль.")
    public String password;
}
