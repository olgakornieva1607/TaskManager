package pl.coderslab.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.taskmanager.model.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findTasksByProjectId(Long id);
}
