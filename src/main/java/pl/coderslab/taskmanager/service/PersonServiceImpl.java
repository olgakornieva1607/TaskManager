package pl.coderslab.taskmanager.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.taskmanager.model.User;
import pl.coderslab.taskmanager.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService{

    private final UserRepository userRepository;

    @Override
    public Optional<User> findByUserName(String name) {
        return Optional.ofNullable(userRepository.findByUsername(name));
    }
}
