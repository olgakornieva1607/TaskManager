package pl.coderslab.taskmanager.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.taskmanager.model.Project;
import pl.coderslab.taskmanager.repository.ProjectRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService{
    private final ProjectRepository projectRepository;

    @Override
    public List<Project> getProjects() {

        return projectRepository.findAll();
    }

    @Override
    public List<Project> findProjectsByUserId(Long id) {
        return projectRepository.findProjectsByUserId(id);
    }

    @Override
    public void add(Project project) {
        projectRepository.save(project);
    }

    @Override
    public Project get(Long id) {
        Optional<Project> foundProject = projectRepository.findById(id);
        return foundProject.orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void delete(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public void update(Project project) {
        projectRepository.save(project);
    }

}
