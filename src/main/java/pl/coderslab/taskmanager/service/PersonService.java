package pl.coderslab.taskmanager.service;


import pl.coderslab.taskmanager.model.User;

import java.util.Optional;


public interface PersonService {

    Optional<User> findByUserName(String name);
}
