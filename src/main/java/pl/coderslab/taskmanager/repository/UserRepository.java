package pl.coderslab.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.taskmanager.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername (String username);
}
