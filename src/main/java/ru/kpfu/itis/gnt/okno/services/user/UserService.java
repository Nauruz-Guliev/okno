package ru.kpfu.itis.gnt.okno.services.user;


import ru.kpfu.itis.gnt.okno.dto.user.UserCreateDto;
import ru.kpfu.itis.gnt.okno.dto.user.UserDto;
import ru.kpfu.itis.gnt.okno.dto.user.UserLoginForm;
import ru.kpfu.itis.gnt.okno.dto.user.UserUpdateDto;

public interface UserService {

    UserDto create(UserCreateDto dto);

    UserDto read(Long id, Long authId);

    UserDto update(UserUpdateDto dto, Long authId);

    UserDto delete(Long id, Long authId);

    UserDto login(UserLoginForm loginForm);
}
