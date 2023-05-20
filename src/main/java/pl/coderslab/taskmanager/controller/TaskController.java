package pl.coderslab.taskmanager.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.taskmanager.model.Task;
import pl.coderslab.taskmanager.security.PersonDetails;
import pl.coderslab.taskmanager.service.ProjectService;
import pl.coderslab.taskmanager.service.TaskService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;



@Controller
@RequiredArgsConstructor
@RequestMapping("tasks")
public class TaskController {

    private static final String TASK_TASK_EDIT = "/task/task-edit";
    private final TaskService taskService;
    private final ProjectService projectService;
    private final UserDetailsService userDetailsService;

    @GetMapping("/{id}/new")
    public String showAddTaskForm(@PathVariable Long id, Model model, Principal principal) {
        Task task = new Task();
        task.setProject(projectService.get(id));
        String username = principal.getName();
        PersonDetails personDetails = (PersonDetails) userDetailsService.loadUserByUsername(username);
        task.setUser(personDetails.getUser());
        model.addAttribute("task", task);
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


        @PutMapping("")
        public String performUpdateTask(@Valid @ModelAttribute("taskToEdit") Task task, BindingResult result){
            if(result.hasErrors()){
                return TASK_TASK_EDIT;
            }

            taskService.updateTask(task);
            Long id = task.getProject().getId();
            return "redirect:/projects/"+ id +"/details";
        }

    }










