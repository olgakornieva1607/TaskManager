package pl.coderslab.taskmanager.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import pl.coderslab.taskmanager.model.Project;
import pl.coderslab.taskmanager.model.Task;

import pl.coderslab.taskmanager.service.ProjectService;
import pl.coderslab.taskmanager.service.TaskService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;


@Controller
@RequiredArgsConstructor
@RequestMapping("tasks")
public class TaskController {

    private static final String TASK_TASK_EDIT = "/task/task-edit";
    private final TaskService taskService;
    private final ProjectService projectService;

    @GetMapping("/{id}/new")
    public String showAddTaskForm(@PathVariable Long id, Model model, Principal principal) {

        Optional<Project> projectOptional = projectService.get(id);
        if(projectOptional.isPresent()){
            Project project = projectOptional.get();
            Task task = new Task();
            task.setProject(project);
            model.addAttribute("task", task);
        }

        return "task/task-add";
    }


        @PostMapping("")
        public String addTask(@Valid @ModelAttribute("task") Task task, BindingResult result) {
            if (result.hasErrors()) {
                return "task/task-add";
            }
            taskService.add(task);
            Long id = task.getProject().getId();
            return "redirect:/projects/"+ id +"/details";
        }


        @GetMapping("/{id}")
        public String deleteTask(@PathVariable Long id, HttpServletRequest request) {
            taskService.deleteTask(id);
            String referer = request.getHeader("Referer");
            return "redirect:" + referer;
        }


        @GetMapping("/{id}/edit")
        public String editTask(@PathVariable Long id, Model model){
            model.addAttribute("taskToEdit", taskService.getTask(id));
            return TASK_TASK_EDIT;

        }


        @PostMapping("/edit")
        public String performUpdateTask(@Valid @ModelAttribute("taskToEdit") Task task, BindingResult result){
            if(result.hasErrors()){
                return TASK_TASK_EDIT;
            }

            taskService.updateTask(task);
            Long id = task.getProject().getId();
            return "redirect:/projects/"+ id +"/details";
        }

    }










