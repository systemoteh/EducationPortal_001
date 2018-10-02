package ru.systemoteh.educationportal.dao.security;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.systemoteh.educationportal.model.Lecture;
import ru.systemoteh.educationportal.model.User;

import java.util.List;

public interface UserSecurityDao extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
