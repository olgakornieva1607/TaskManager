package pl.coderslab.taskmanager.util;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.coderslab.taskmanager.model.User;
import pl.coderslab.taskmanager.service.SpringDataUserDetailsService;


@Component
@RequiredArgsConstructor
public class UserValidator implements Validator {

    private final SpringDataUserDetailsService springDataUserDetailsService;


    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        User user = (User)target;
        try {
            springDataUserDetailsService.loadUserByUsername(user.getUsername());
        }catch (UsernameNotFoundException ignored){
            return;
        }
        errors.rejectValue("username", "registration.username.exist", "Username already exists");

    }
}
