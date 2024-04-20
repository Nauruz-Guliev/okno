package ru.kpfu.itis.gnt.okno.controllers.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.itis.gnt.okno.dto.base.Response;
import ru.kpfu.itis.gnt.okno.dto.user.UserDto;
import ru.kpfu.itis.gnt.okno.dto.user.UserLoginForm;


@Tags(value = {
        @Tag(name = "Authentication. Аутентификация.")
})
@RequestMapping("/auth")
public interface AuthApi {

    @Operation(summary = "Аутентифицироваться.")
    @PostMapping("/login")
    Response<UserDto> login(@RequestBody UserLoginForm dto);
}
