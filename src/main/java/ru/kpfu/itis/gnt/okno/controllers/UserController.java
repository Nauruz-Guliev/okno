package ru.kpfu.itis.gnt.okno.controllers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.itis.gnt.okno.controllers.api.UserApi;
import ru.kpfu.itis.gnt.okno.dto.base.Response;
import ru.kpfu.itis.gnt.okno.dto.user.UserCreateDto;
import ru.kpfu.itis.gnt.okno.dto.user.UserDto;
import ru.kpfu.itis.gnt.okno.dto.user.UserUpdateDto;
import ru.kpfu.itis.gnt.okno.services.user.UserService;


@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserController implements UserApi {

    UserService service;

    public Response<UserDto> create(UserCreateDto dto) {
        return Response.of(
                service.create(dto));
    }

    public Response<UserDto> read(Long id, Long authId) {
        return Response.of(
                service.read(id, authId));
    }

    public Response<UserDto> update(UserUpdateDto dto, Long authId) {
        return Response.of(
                service.update(dto, authId));
    }

    public Response<UserDto> delete(Long id, Long authId) {
        return Response.of(
                service.delete(id, authId));
    }
}
