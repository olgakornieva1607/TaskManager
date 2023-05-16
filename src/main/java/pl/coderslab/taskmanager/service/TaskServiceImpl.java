package pl.coderslab.taskmanager.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.coderslab.taskmanager.model.Task;
import pl.coderslab.taskmanager.repository.TaskRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;


    @Override
    public List<Task> findTasksByProjectId(Long id) {
        return taskRepository.findTasksByProjectId(id);
    }

    @Override
    public void add(Task task) {
        taskRepository.save(task);
    }

    @Override
    public Task getTask(Long id) {
        Optional <Task> foundTask = taskRepository.findById(id);
        return foundTask.orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public void updateTask(Task task) {
        taskRepository.save(task);
    }
}
