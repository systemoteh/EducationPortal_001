package ru.systemoteh.educationportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.systemoteh.educationportal.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User findById(long id);

    User findByUserDetailEmail(String email);

}
