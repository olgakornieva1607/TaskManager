package pl.coderslab.taskmanager.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.taskmanager.model.User;
import pl.coderslab.taskmanager.service.UserService;
import pl.coderslab.taskmanager.util.UserValidator;

import javax.validation.Valid;


@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserValidator userValidator;
    private final UserService userService;

    @GetMapping("/")
    public String login() {
        return "auth/login";
    }


    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("user") User user){
        return "auth/registration";
    }


    @PostMapping("/registration")
    public String performRegistration(@Valid @ModelAttribute("user") User user,
                                      BindingResult bindingResult){

        userValidator.validate(user, bindingResult);
        if(bindingResult.hasErrors()){
            return "auth/registration";
        }
        userService.saveUser(user);
        return "redirect:/";

    }

}
