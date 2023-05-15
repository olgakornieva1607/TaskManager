package pl.coderslab.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.taskmanager.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
