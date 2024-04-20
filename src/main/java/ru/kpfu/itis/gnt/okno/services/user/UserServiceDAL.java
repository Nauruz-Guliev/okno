package ru.kpfu.itis.gnt.okno.services.user;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.gnt.okno.dal.UserRepository;
import ru.kpfu.itis.gnt.okno.dal.models.User;
import ru.kpfu.itis.gnt.okno.dto.user.UserCreateDto;
import ru.kpfu.itis.gnt.okno.dto.user.UserDto;
import ru.kpfu.itis.gnt.okno.dto.user.UserLoginForm;
import ru.kpfu.itis.gnt.okno.dto.user.UserUpdateDto;
import ru.kpfu.itis.gnt.okno.exceptions.ApplicationException;
import ru.kpfu.itis.gnt.okno.exceptions.DataAccessException;
import ru.kpfu.itis.gnt.okno.exceptions.DataNotFoundException;
import ru.kpfu.itis.gnt.okno.services.utils.HashGenerator;
import ru.kpfu.itis.gnt.okno.services.utils.StackWalkerUtil;


@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserServiceDAL implements UserService {

    UserRepository repository;
    UserMapper mapper;
    HashGenerator hashGenerator;

    public UserDto create(UserCreateDto dto) {
        return mapper.map(
                saveInternal(
                        mapper.map(dto)));
    }

    public UserDto read(Long id, Long authId) {
        checkAccess(id, authId);
        return mapper.map(
                readInternal(id));
    }

    public UserDto update(UserUpdateDto dto, Long authId) {
        checkAccess(dto.id, authId);
        return mapper.map(
                saveInternal(
                        mapper.map(
                                readInternal(dto.id),
                                dto)));
    }

    public UserDto delete(Long id, Long authId) {
        checkAccess(id, authId);
        return mapper.map(
                deleteInternal(id));
    }

    public UserDto login(UserLoginForm loginForm) {
        var passwordHash = hashGenerator.hash(loginForm.password);
        var dal = repository.getByEmailAndPasswordHash(loginForm.login, passwordHash);
        if (dal.isPresent())
            return mapper.map(dal.get());
        else
            throw new ApplicationException("Invalid username or password.", "email=" + loginForm.login, "passwordHash=" + passwordHash);
    }

    protected User readInternal(Long id) {
        var opt = repository.findById(id);
        if (opt.isPresent())
            return opt.get();
        else
            throw new DataNotFoundException("User", "id=" + id);
    }

    protected User saveInternal(User dal) {
        checkUniqueFields(dal);
        return repository.save(dal);
    }

    protected User deleteInternal(Long id) {
        var dal = readInternal(id);
        repository.delete(dal);
        return dal;
    }


    protected void checkAccess(Long ownerId, Long authId) {
        if (!ownerId.equals(authId))
            throw new DataAccessException(StackWalkerUtil.getCaller(), ownerId, authId);
    }

    protected void checkUniqueFields(User dal) {
        if (repository.existsByEmail(dal.getEmail()))
            throw new ApplicationException("A user with an email \"" + dal.getEmail() + "\" already exists.");
    }

}
