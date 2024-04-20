package ru.kpfu.itis.gnt.okno.services.user;


import ru.kpfu.itis.gnt.okno.dal.models.User;
import ru.kpfu.itis.gnt.okno.dto.user.UserCreateDto;
import ru.kpfu.itis.gnt.okno.dto.user.UserDto;
import ru.kpfu.itis.gnt.okno.dto.user.UserUpdateDto;

public interface UserMapper {

    UserDto map(User dal);

    User map(UserCreateDto dto);

    User map(User dal, UserUpdateDto dto);
}
