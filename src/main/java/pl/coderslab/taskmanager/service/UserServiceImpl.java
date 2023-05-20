package pl.coderslab.taskmanager.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.taskmanager.model.Role;
import pl.coderslab.taskmanager.model.User;
import pl.coderslab.taskmanager.repository.RoleRepository;
import pl.coderslab.taskmanager.repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    @Override
    public User findByUserName(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
//        Role userRole = roleRepository.findByName("ROLE_USER");
//        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        userRepository.save(user);

    }

}
