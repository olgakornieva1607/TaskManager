package pl.coderslab.taskmanager.service;

import pl.coderslab.taskmanager.model.Task;

import java.util.List;

public interface TaskService {

    List<Task> findTasksByProjectId(Long id);

    void add(Task task);

    Task getTask(Long id);

    void deleteTask(Long id);

    void updateTask(Task task);
}
