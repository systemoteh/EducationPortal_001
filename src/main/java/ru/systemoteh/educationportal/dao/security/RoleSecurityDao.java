package ru.systemoteh.educationportal.dao.security;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.systemoteh.educationportal.model.Role;

public interface RoleSecurityDao extends JpaRepository<Role, Long> {
}
