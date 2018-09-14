package ru.systemoteh.educationportal.service;


import ru.systemoteh.educationportal.model.User;

/**
 * Service class for {@link User}
 */

public interface UserService {

    void save(User user);

    User findByUsername(String username);

}