package ru.kpfu.itis.gnt.okno.controllers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.itis.gnt.okno.controllers.api.AuthApi;
import ru.kpfu.itis.gnt.okno.dto.base.Response;
import ru.kpfu.itis.gnt.okno.dto.user.UserDto;
import ru.kpfu.itis.gnt.okno.dto.user.UserLoginForm;
import ru.kpfu.itis.gnt.okno.services.user.UserService;


@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthController implements AuthApi {

    UserService service;

    @Override
    public Response<UserDto> login(UserLoginForm dto) {
        return Response.of(
                service.login(dto));
    }
}
