package ru.kpfu.itis.gnt.okno.dal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.gnt.okno.dal.models.Task;
import ru.kpfu.itis.gnt.okno.dal.models.User;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Page<Task> findAllByUserAndIsCompletedOrderByDeadlineTime(Pageable pageable, User user, Boolean isCompleted);


    Page<Task> findAllByUserAndIsCompletedOrderByCompletedTimeDesc(Pageable pageable, User user, Boolean isCompleted);
}
