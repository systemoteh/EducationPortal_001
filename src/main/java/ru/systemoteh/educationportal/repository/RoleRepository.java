package ru.systemoteh.educationportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.systemoteh.educationportal.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
