package pl.coderslab.taskmanager.service;

import pl.coderslab.taskmanager.model.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {

    List<Project> getProjects();

    void add(Project project);

    Optional<Project> get(Long id);

    void delete(Long id);

    void update(Project project);


}
