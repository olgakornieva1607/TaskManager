package pl.coderslab.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.taskmanager.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
