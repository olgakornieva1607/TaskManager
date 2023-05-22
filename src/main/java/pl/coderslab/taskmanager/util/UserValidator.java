package pl.coderslab.taskmanager.util;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.coderslab.taskmanager.model.User;
import pl.coderslab.taskmanager.service.PersonService;
import java.util.Optional;


@Component
@RequiredArgsConstructor
public class UserValidator implements Validator {

    private final PersonService personService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        String username = user.getUsername();
        Optional<User> existingUser = personService.findByUserName(username);
        if(existingUser.isPresent()){
            errors.rejectValue("username","registration.username.exist", "Username already exists");
        }
    }

}
