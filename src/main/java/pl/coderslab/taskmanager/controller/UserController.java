//package pl.coderslab.taskmanager.controller;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import pl.coderslab.taskmanager.model.User;
//import pl.coderslab.taskmanager.service.UserService;
//
//@Controller
//@RequiredArgsConstructor
//public class UserController {
//
//    private final UserService userService;
//
//    @GetMapping("/user")
//    @ResponseBody
//    public String createUser() {
//        User user = new User();
//        user.setUsername("admin");
//        user.setPassword("admin");
//        userService.saveUser(user);
//        return "admin";
//    }
//
//}
