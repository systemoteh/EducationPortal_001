package ru.systemoteh.educationportal.prim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.systemoteh.educationportal.prim.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User findById(long id);

    User findByUserDetailEmail(String email);

}
