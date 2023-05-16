package pl.coderslab.taskmanager.service;

import pl.coderslab.taskmanager.model.Project;

import java.util.List;


public interface ProjectService {

    List<Project> getProjects();

    void add(Project project);

    Project get(Long id);

    void delete(Long id);

    void update(Project project);

}
