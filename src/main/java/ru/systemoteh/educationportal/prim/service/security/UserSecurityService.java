package ru.systemoteh.educationportal.prim.service.security;


import ru.systemoteh.educationportal.prim.model.User;

/**
 * Service class for {@link User}
 */

public interface UserSecurityService {

    void save(User user);

    User findByUsername(String username);

}