package ru.kpfu.itis.gnt.okno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.gnt.okno.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
