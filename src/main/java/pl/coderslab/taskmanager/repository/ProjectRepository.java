package pl.coderslab.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.taskmanager.model.Project;


import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

     List<Project> findProjectsByUserId(Long id);
}
