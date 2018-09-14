package ru.systemoteh.educationportal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.systemoteh.educationportal.model.User;

public interface UserDao extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
