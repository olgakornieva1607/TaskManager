package pl.coderslab.taskmanager.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.taskmanager.model.Project;
import pl.coderslab.taskmanager.security.PersonDetails;
import pl.coderslab.taskmanager.service.ProjectService;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.taskmanager.service.TaskService;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("projects")
public class ProjectController {
    private static final String REDIRECT_PROJECTS_ALL = "redirect:/projects/all";
    private static final String PROJECT_PROJECT_ADD = "/project/project-add";
    private static final String PROJECT_PROJECT_EDIT = "/project/project-edit";
    private final ProjectService projectService;
    private final TaskService taskService;

    private final UserDetailsService userDetailsService;

    @GetMapping("/all")
    public String showAllProjectsByUser(Model model, Principal principal){
        String username = principal.getName();
        PersonDetails personDetails = (PersonDetails) userDetailsService.loadUserByUsername(username);
        Long userId = personDetails.getId();
        List<Project> projects = projectService.findProjectsByUserId(userId);
        model.addAttribute("projects", projects);
        return "project/project-all";
    }


    @GetMapping("/new")
    public String addProject(Model model, Principal principal){
        Project project = new Project();
        String username = principal.getName();
        PersonDetails personDetails = (PersonDetails) userDetailsService.loadUserByUsername(username);
        project.setUser(personDetails.getUser());
        model.addAttribute("project", project);
        return PROJECT_PROJECT_ADD;
    }


    @PostMapping("")
    public String performAddProject(@Valid @ModelAttribute("project") Project project, BindingResult result){
        if(result.hasErrors()){
            return PROJECT_PROJECT_ADD;
        }
        projectService.add(project);
        return REDIRECT_PROJECTS_ALL;
    }



    @GetMapping("/{id}")
    public String deleteProject(@PathVariable Long id) {
        projectService.delete(id);
        return REDIRECT_PROJECTS_ALL;
    }


    @GetMapping("/{id}/edit")
    public String editProject(@PathVariable Long id, Model model){
        model.addAttribute("projectToEdit", projectService.get(id));
        return PROJECT_PROJECT_EDIT;
    }


    @PutMapping("")
    public String performUpdateProject(@Valid @ModelAttribute("projectToEdit") Project project, BindingResult result) {
        if(result.hasErrors()){
            return PROJECT_PROJECT_EDIT;
        }
        projectService.update(project);
        return REDIRECT_PROJECTS_ALL;
    }


    @GetMapping("/{id}/details")
    public String showProjectDetails(@PathVariable Long id, Model model){
        model.addAttribute("project", projectService.get(id));
        model.addAttribute("tasks", taskService.findTasksByProjectId(id));
        return "/project/project-show";
    }

}





