package ru.kpfu.itis.gnt.okno.controllers.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.gnt.okno.dto.base.Response;
import ru.kpfu.itis.gnt.okno.dto.user.UserCreateDto;
import ru.kpfu.itis.gnt.okno.dto.user.UserDto;
import ru.kpfu.itis.gnt.okno.dto.user.UserUpdateDto;


@Tags(value = {
        @Tag(name = "User. Пользователь.")
})
@RequestMapping("/user")
public interface UserApi {

    @Operation(summary = "Добавить.")
    @PostMapping
    Response<UserDto> create(@RequestBody UserCreateDto dto);

    @Operation(summary = "Получить.")
    @GetMapping("/{user-id}")
    Response<UserDto> read(@Parameter(description = "Идентификатор.")
                           @PathVariable("user-id") Long id,
                           @Parameter(description = "Идентификатор для авторизации.")
                           @RequestHeader(name = "Auth") Long authId);

    @Operation(summary = "Изменить.")
    @PutMapping
    Response<UserDto> update(@RequestBody UserUpdateDto dto,
                             @Parameter(description = "Идентификатор для авторизации.")
                             @RequestHeader(name = "Auth") Long authId);

    @Operation(summary = "Удалить.")
    @DeleteMapping("/{user-id}")
    Response<UserDto> delete(@Parameter(description = "Идентификатор.")
                             @PathVariable("user-id") Long id,
                             @Parameter(description = "Идентификатор для авторизации.")
                             @RequestHeader(name = "Auth") Long authId);

}
