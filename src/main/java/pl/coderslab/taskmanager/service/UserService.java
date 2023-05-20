package pl.coderslab.taskmanager.service;

import pl.coderslab.taskmanager.model.User;

public interface UserService {
    User findByUserName(String name);

    void saveUser(User user);

}
