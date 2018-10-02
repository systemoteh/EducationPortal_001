package ru.systemoteh.educationportal.service.security;


import ru.systemoteh.educationportal.model.User;

/**
 * Service class for {@link User}
 */

public interface UserSecurityService {

    void save(User user);

    User findByUsername(String username);

}