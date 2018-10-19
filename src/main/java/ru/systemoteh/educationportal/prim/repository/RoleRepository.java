package ru.systemoteh.educationportal.prim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.systemoteh.educationportal.prim.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
