package ru.kpfu.itis.gnt.okno.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.gnt.okno.dal.models.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> getByEmailAndPasswordHash(String email, String passwordHash);

    Boolean existsByEmail(String email);
}
